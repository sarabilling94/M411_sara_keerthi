package com.company;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BeerAdmin {
    private HashMap<Integer, String> hashMapbeers;
    ArrayList<beer> beers = new ArrayList<>();

    public ArrayList<beer> loadBeers() throws IOException {
        beers = new ArrayList<>();
        JsonNode jsonNode = JsonReader.apiCall("beers", "");
        for (JsonNode style : jsonNode.get("data")) {
            String id = style.get("id").asText();
            String name = style.get("name").asText();
            String description = style.get("description").asText();
            Integer idStyle = style.get("styleId").asInt();
            beers.add(new beer(id, name, description, idStyle));
        }
        return beers;
    }

    public static HashMap<Integer, String> loadBeerStyles() throws IOException {
        HashMap hashMap = new HashMap<Integer, String>();
        JsonNode jsonNode = JsonReader.apiCall("styles", "");
        for (JsonNode style : jsonNode.get("data")) {
            Integer id = style.get("id").asInt();
            String name = style.get("name").asText();
            hashMap.put(id, name);
        }

        return hashMap;
    }

    public void printBeerStyles() throws IOException {
        hashMapbeers = loadBeerStyles();
        hashMapbeers.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });
    }

    public void printBeerStyles(String search) throws IOException {
        hashMapbeers = loadBeerStyles();
        hashMapbeers.forEach((key, value) -> {
            if (value.contains(search)) {
                System.out.println(key + "::" + value);
            }
        });
    }

    public void getBeerListForStyle(int idStyle) {
        String url = "http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=" + idStyle;

    }

    public void printBeerList() throws IOException {
        hashMapbeers = loadBeerStyles();
        hashMapbeers.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }

    public void printBeer(String id) throws IOException {
        hashMapbeers = loadBeerStyles();
        hashMapbeers.forEach((key, value) -> {
            System.out.println("Bier: " + key + " - " + value + "\n" + description);
        });
    }
}
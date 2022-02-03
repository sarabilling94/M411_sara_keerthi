package com.company;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BeerAdmin {
    private HashMap<Integer, String> hashMapbeers;
    private ArrayList<beer> beers = new ArrayList<>();

    public ArrayList<beer> loadBeers() throws IOException {
        beers = new ArrayList<>();
        JsonNode jsonNode = JsonReader.apiCall("beers", "");
        for (JsonNode style : jsonNode.get("data")) {
            String id = style.get("id").asText();
            String name = style.get("name").asText();
            String description = "";
            Integer idStyle = 0;
            try {
                description = style.get("description").asText();
            } catch (Exception e) {
            }
            try {
                idStyle = style.get("styleId").asInt();
            } catch (Exception e) {
            }
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

    public HashMap<Integer, beer> getBeerListForStyle(int styleId) throws IOException {
        HashMap<Integer, beer> beersForStyle = new HashMap<>();
        JsonNode jsonNode = JsonReader.apiCall("beers", String.valueOf(styleId));
        for (JsonNode style : jsonNode.get("data")) {
            String id = style.get("id").asText();
            String name = style.get("name").asText();
            String description = style.get("description").asText();
            Integer idStyle = style.get("styleId").asInt();
            beersForStyle.put(Integer.parseInt(id), new beer(id, name, description, idStyle));
        }
        return beersForStyle;
    }

    public void printBeerList() throws IOException {
        hashMapbeers = loadBeerStyles();
        hashMapbeers.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });
    }

    public void printBeer(String id) throws IOException {
        beers = loadBeers();
        beers.forEach((beer) -> {
            if (beer.getId().equals(id)) {
                System.out.println(id + "::" + beer.getName() + "\n" + beer.getDescription());
            }
        });
    }
}
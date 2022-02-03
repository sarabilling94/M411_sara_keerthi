package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class BeerAdmin {
    private HashMap<Integer, String> beers;

    public ArrayList<beer> loadBeers() throws IOException {
        ArrayList<beer> beers = new ArrayList<>();
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
        beers = loadBeerStyles();
        beers.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });
    }

    public void printBeerStyles(String search) throws IOException {
        beers = loadBeerStyles();
        beers.forEach((key, value) ->{
            if(value.contains(search)){
                System.out.println(key + "::" + value);
            }
        });
    }

    public void getBeerListForStyle(int idStyle) {

    }

    public void printBeerList() {

    }

    public void printBeer(String id) {

    }
}
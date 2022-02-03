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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class BeerAdmin {
    private HashMap<Integer, String> beers;

    public static HashMap<Integer, String> loadBeerStyles() throws IOException {
        String url = "http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff";
        HashMap hashMap = new HashMap<Integer, String>();
        JSONObject json = JsonReader.readJsonFromUrl(url);
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
            System.out.print(key + "::" + value);
        });
    }

    public void printBeerStyles(String search) {

    }

    public void getBeerListForStyle(int idStyle) {

    }

    public void printBeerList() {

    }

    public void printBeer(String id) {

    }
}
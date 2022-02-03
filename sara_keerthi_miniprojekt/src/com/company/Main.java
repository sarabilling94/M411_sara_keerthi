package com.company;


import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {
        String apiKey = "?key=1511d0db4a1d6841481c672455358cff";
        String url = "http://api.brewerydb.com/v2/";

        //JSONObject json = JsonReader.readJsonFromUrl("http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=5");
        //System.out.println(json.toString());

        //JSONObject json = JsonReader.readJsonFromUrl("http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff");
        //System.out.println(json.toString());

        //HashMap<Integer, String> hashMap = BeerAdmin.loadBeerStyles("http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff");



        JsonNode jsonNode = JsonReader.apiCall("styles", "");
        System.out.println(jsonNode);

    }
}

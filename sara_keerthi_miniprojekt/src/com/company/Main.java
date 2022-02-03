package com.company;


import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {
        String apiKey = "?key=1511d0db4a1d6841481c672455358cff";

        BeerAdmin beerAdmin = new BeerAdmin();
        //JSONObject json = JsonReader.readJsonFromUrl("http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=5");
        //System.out.println(json.toString());

        //JSONObject json = JsonReader.readJsonFromUrl("http://api.brewerydb.com/v2/styles/?key=1511d0db4a1d6841481c672455358cff");
        //System.out.println(json.toString());



        //HashMap<Integer, String> hashMap = BeerAdmin.loadBeerStyles();
        //beerAdmin.printBeerStyles();

        //beerAdmin.printBeerStyles("Cider");

        //JsonNode jsonNode = JsonReader.apiCall("styles", "");
        //System.out.println(jsonNode);

        beerAdmin.printBeer("98");

    }
}

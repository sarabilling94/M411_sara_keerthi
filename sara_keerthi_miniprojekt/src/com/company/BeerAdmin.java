package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

public class BeerAdmin {

    public static HashMap<Integer, String> loadBeerStyles(String url) throws IOException {
        HashMap hashMap = new HashMap<Integer, String>();
        JSONObject json = JsonReader.readJsonFromUrl(url);

        JSONArray c = (JSONArray) new JSONParser()
                .parse(json);
        for (int i = 0; i < c.size(); i++) {
            JSONObject obj = (JSONObject) c.get(i);
            System.out.println(obj.get("name"));
        }


        return hashMap;
    }

    public void printBeerStyles(){

    }

    public void printBeerStyles(String search){

    }
    public void getBeerListForStyle(int idStyle){

    }

    public void printBeerList(){

    }

    public void printBeer(String id){

    }
}
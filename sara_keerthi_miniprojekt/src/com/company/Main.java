package com.company;


import java.io.IOException;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject json = JsonReader.readJsonFromUrl("http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=5");
        System.out.println(json.toString());
    }
}

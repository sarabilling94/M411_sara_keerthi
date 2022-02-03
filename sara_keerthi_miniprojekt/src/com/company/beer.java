package com.company;

public class beer {
    private String id;
    private String name;
    private String description;
    private int idStyle;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public beer(String id, String name, String description, int idStyle){
        this.id = id;
        this.name = name;
        this.description = description;
        this.idStyle = idStyle;
    }


    @Override
    public String toString(){
        //String idStyleString = Integer.toString(idStyle);
        String beerString = String.format("" + id + ";" + name + ";" + description + "%d",idStyle);
        System.out.println(beerString);
        return null;
    }

}
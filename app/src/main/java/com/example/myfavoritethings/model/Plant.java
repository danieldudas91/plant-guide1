package com.example.myfavoritethings.model;

public class Plant {

    private int id;
    private String name;
    private String scientificName;
    private String pictureUrl;
    private String description;

    public Plant(String name, String scientificName, String scientificName1, String pictureUrl, String description) {
        this.name = name;
        this.scientificName = scientificName1;
        this.pictureUrl = pictureUrl;
        this.description = description;
    }
}
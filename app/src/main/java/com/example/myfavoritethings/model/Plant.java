package com.example.myfavoritethings.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plants")
public class Plant {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ColumnInfo(name = "scientific_name")
    private String scientificName;
    @ColumnInfo(name = "picture_url")
    private String pictureUrl;
    private String description;

    public Plant(String name, String scientificName1, String pictureUrl, String description) {
        this.name = name;
        this.scientificName = scientificName1;
        this.pictureUrl = pictureUrl;
        this.description = description;
    }
}
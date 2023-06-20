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
    @ColumnInfo(name = "geographic_region")
    private GeographicRegion region;

    public Plant(String name, String scientificName, String pictureUrl, String description, GeographicRegion region) {
        this.name = name;
        this.scientificName = scientificName;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
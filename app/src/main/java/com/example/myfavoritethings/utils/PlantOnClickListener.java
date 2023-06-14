package com.example.myfavoritethings.utils;

import android.view.View;

public class PlantOnClickListener implements View.OnClickListener{

    private String name;
    private String scientificName;
    private String description;
    private String imageUrl;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void onClick(View view) {

    }
}

package com.example.myfavoritethings.data.cache;

import com.example.myfavoritethings.model.GeographicRegion;
import com.example.myfavoritethings.model.Plant;

import java.util.HashMap;
import java.util.List;

public class PlantCache {

    private static PlantCache INSTANCE;
    public HashMap<GeographicRegion, List<Plant>> cache;


    private PlantCache() {
        cache = new HashMap<>();
    }


    public HashMap<GeographicRegion, List<Plant>> getCache() {
        return cache;
    }


    public static PlantCache getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new PlantCache();
        }
        return INSTANCE;
    }
}

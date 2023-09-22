package com.example.myfavoritethings.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.myfavoritethings.data.cache.PlantCache;
import com.example.myfavoritethings.data.repository.PlantRepository;
import com.example.myfavoritethings.model.GeographicRegion;
import com.example.myfavoritethings.model.Plant;
import java.util.HashMap;
import java.util.List;

public class PlantViewModel extends AndroidViewModel {

    private LiveData<List<Plant>> allPlants;
    private PlantRepository plantRepository;

    public PlantViewModel(@NonNull Application application) {
        super(application);
        plantRepository = new PlantRepository(application);
        allPlants = plantRepository.getAllPlants();
    }

    public LiveData<List<Plant>> getAllPlants() {
        return allPlants;
    }

    public LiveData<List<Plant>> getPlantsByRegion(GeographicRegion region) {
        HashMap<GeographicRegion, List<Plant>> cache = PlantCache.getINSTANCE().cache;
        List<Plant> plantsInCache = cache.get(region);
        if(plantsInCache != null){
            return (LiveData<List<Plant>>) new MutableLiveData<>(plantsInCache);
        }
        LiveData<List<Plant>> result = plantRepository.getPlantsByRegion(region);
        cache.put(region, result.getValue());
        return result;
    }

    public void insert(Plant plant) {
        plantRepository.insert(plant);
    }

    public void deleteAll() {
        plantRepository.deleteAll();
    }

    public void deleteById(int id) {
        plantRepository.deleteById(id);
    }

    public void updatePlant(String name, String scientificName, String description, String imageUrl, int id) {
        plantRepository.updatePlant(name, scientificName, description, imageUrl, id);
    }
}


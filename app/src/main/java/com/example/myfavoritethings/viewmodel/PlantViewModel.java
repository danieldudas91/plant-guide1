package com.example.myfavoritethings.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.myfavoritethings.data.repository.PlantRepository;
import com.example.myfavoritethings.model.GeographicRegion;
import com.example.myfavoritethings.model.Plant;
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
        return plantRepository.getPlantsByRegion(region);
    }

    public void insert(Plant plant){
        plantRepository.insert(plant);
    }

    public void deleteAll(){
        plantRepository.deleteAll();
    }

    public void deleteById(int id){
        plantRepository.deleteById(id);
    }

    public void updatePlant(String name, String scientificName, String description, String imageUrl, int id){
        plantRepository.updatePlant(name, scientificName, description, imageUrl, id);
    }
}


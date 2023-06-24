package com.example.myfavoritethings.data.repository;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.myfavoritethings.data.DAO.PlantDao;
import com.example.myfavoritethings.data.database.PlantDatabase;
import com.example.myfavoritethings.model.GeographicRegion;
import com.example.myfavoritethings.model.Plant;
import java.util.List;

public class PlantRepository {

    private PlantDao plantDao;
    private LiveData<List<Plant>> allPlants;

    public PlantRepository(Application application) {
        PlantDatabase database = PlantDatabase.getInstance(application);
        this.plantDao = database.plantDao();
        this.allPlants = plantDao.getAllPlants();
    }

    public LiveData<List<Plant>> getAllPlants() {
        return allPlants;
    }
    public LiveData<List<Plant>> getPlantsByRegion(GeographicRegion region) {
        return plantDao.getPlantsByRegion(region);
    }

    public void insert(Plant plant){
        PlantDatabase.databaseWriteExecutor.execute(() -> {
            plantDao.insert(plant);
        });
    }

    public void deleteAll(){
        PlantDatabase.databaseWriteExecutor.execute(() -> {
            plantDao.deleteAll();
        });
    }

    public void deleteById(int id){
        PlantDatabase.databaseWriteExecutor.execute(() ->{
            plantDao.deleteById(id);
        });
    }

    public void updatePlant(String name, String scientificName, String description, String imageUrl, int id){
        PlantDatabase.databaseWriteExecutor.execute(() ->{
            plantDao.updatePlant(name, scientificName, description, imageUrl, id);
        });
    }
}
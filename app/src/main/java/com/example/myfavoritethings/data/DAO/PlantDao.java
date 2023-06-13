package com.example.myfavoritethings.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myfavoritethings.model.Plant;

import java.util.List;

@Dao
public interface PlantDao {

    @Query("SELECT * FROM plants")
    LiveData<List<Plant>> getAllDestinations();

    @Query("DELETE FROM plants")
    void deleteAll();

    @Query("DELETE FROM plants WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE plants SET name = :name, description = :description, picture_url = :imageUrl WHERE id = :id ")
    void updateDestination(String name, String description, String imageUrl, int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Plant plant);
}

package com.example.myfavoritethings.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myfavoritethings.data.DAO.PlantDao;
import com.example.myfavoritethings.model.Plant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Plant.class}, version = 1, exportSchema = false)
public abstract class PlantDatabase extends RoomDatabase {

    public abstract PlantDao plantDao();
    private static final int NUMBER_OF_THREADS = 4;
    public static ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile PlantDatabase INSTANCE;

    public static PlantDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (PlantDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                                    context, PlantDatabase.class, "plant_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

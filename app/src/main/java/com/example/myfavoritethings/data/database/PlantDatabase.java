package com.example.myfavoritethings.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                            .addCallback(populateDatabase)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback populateDatabase = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            databaseWriteExecutor.execute(() -> {
                PlantDao dao = INSTANCE.plantDao();
                dao.deleteAll();
                Plant plant1 = new Plant(
                        "Common poppy",
                        "Papaver rhoeas",
                        "https://www.everwilde.com/media//0800/resized/FPAPRHR-A-Red-Poppy-Seeds_medium.jpg",
                        "xyz");
                Plant plant2 = new Plant(
                        "Meadow Sage",
                        "Salvia pratensis",
                        "https://florapont.hu/wp-content/uploads/2023/03/Salvia-pratensis-Fashionista-Evening-Attire-zsalya.jpg",
                        "xyz");
                Plant plant3 = new Plant(
                        "White Clover",
                        "Trifolium repens",
                        "https://upload.wikimedia.org/wikipedia/commons/5/52/Trifolium_repens_-_white_clover_on_way_from_Govindghat_to_Gangria_at_Valley_of_Flowers_National_Park_-_during_LGFC_-_VOF_2019_%281%29.jpg",
                        "xyz");
                Plant plant4 = new Plant(
                        "Common Yarrow",
                        "Achillea millefolium",
                        "https://www.fnps.org/assets/images/plants/achillea_millefolium_0002.JPG",
                        "xyz");
                Plant plant5 = new Plant(
                        "Common Nettle",
                        "Urtica dioica",
                        "https://dy3xjh9gbx10h.cloudfront.net/herbs/urtica%20dioica.jpg",
                        "xyz");
                Plant plant6 = new Plant(
                        "Broadleaf Plantain",
                        "Plantago major",
                        "https://p1-ssl.vatera.hu/photos/0a/e2/szeleslevelu-utifu-plantago-major-25-magok-gyogynoveny-e-037-252c_1_big.jpg?v=1",
                        "xyz");
                Plant plant7 = new Plant(
                        "Common Buttercup",
                        "Ranunculus acris",
                        "https://newfs.s3.amazonaws.com/taxon-images-1000s1000/Ranunculaceae/ranunculus-acris-fl-fbramley-a.jpg",
                        "xyz");
                Plant plant8 = new Plant(
                        "Creeping Thistle",
                        "Cirsium arvense",
                        "https://bellepiante.it/wp-content/uploads/2016/06/Cirsium-arvense-4.jpg",
                        "xyz");
                Plant plant9 = new Plant(
                        "Deadly Nightshade",
                        "Atropa belladonna",
                        "https://static.wikia.nocookie.net/terrarium-adventure/images/b/ba/Real_Life_Belladonna.jpeg/revision/latest/scale-to-width-down/1200?cb=20220821072357",
                        "xyz");
                Plant plant10 = new Plant(
                        "Poison Hemlock",
                        "Conium maculatum",
                        "https://upload.wikimedia.org/wikipedia/commons/b/b2/Conium.jpg",
                        "xyz");
                dao.insert(plant1);
                dao.insert(plant2);
                dao.insert(plant3);
                dao.insert(plant4);
                dao.insert(plant5);
                dao.insert(plant6);
                dao.insert(plant7);
                dao.insert(plant8);
                dao.insert(plant9);
                dao.insert(plant10);
            });
        }
    };

}

package com.example.myfavoritethings.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavoritethings.R;
import com.example.myfavoritethings.viewmodel.PlantViewModel;
import com.example.tripplanner.utils.PlantListAdapter;

public class MainActivity extends AppCompatActivity {

    private PlantViewModel viewModel;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        PlantListAdapter adapter = new PlantListAdapter(new PlantListAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new ViewModelProvider(this)
                .get(PlantViewModel.class);
        viewModel.getAllPlants()
                .observe(this, adapter::submitList);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }
}
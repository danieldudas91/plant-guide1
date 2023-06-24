package com.example.myfavoritethings.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavoritethings.R;
import com.example.myfavoritethings.model.GeographicRegion;
import com.example.myfavoritethings.viewmodel.PlantViewModel;
import com.example.tripplanner.utils.PlantListAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private PlantViewModel viewModel;
    private RecyclerView recyclerView;
    private Spinner sortByDropdown;
    private MutableLiveData<GeographicRegion> item;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        sortByDropdown = findViewById(R.id.sort_by_region);
        setRegionSpinnerElements(this, sortByDropdown);
        item = new MutableLiveData<>();
        sortByDropdown.setOnItemSelectedListener(this);
        PlantListAdapter adapter = new PlantListAdapter(new PlantListAdapter.PlantDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new ViewModelProvider(this)
                .get(PlantViewModel.class);
        item.observe(this, value ->
                viewModel.getPlantsByRegion(value)
                .observe(this, adapter::submitList));
    }

    public static void setRegionSpinnerElements(Context context, Spinner dropDown){
        ArrayAdapter<GeographicRegion> dropdownAdapter =
                new ArrayAdapter<GeographicRegion>(context,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        GeographicRegion.values());
        dropDown.setAdapter(dropdownAdapter);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item.setValue((GeographicRegion) adapterView.getSelectedItem());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("nothing selected");
    }
}
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private PlantViewModel viewModel;
    private RecyclerView recyclerView;
    private Spinner sortByDropdown;
    private MutableLiveData<String> item;


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
                viewModel.getPlantsByRegion(GeographicRegion.getRegionByLabel(value))
                .observe(this, adapter::submitList));
    }

    public static void setRegionSpinnerElements(Context context, Spinner dropDown) {
        List<String> regionLabels = Arrays.stream(GeographicRegion.values())
                .map(GeographicRegion::getLabel)
                .collect(Collectors.toList());
        ArrayAdapter<String> dropdownAdapter =
                new ArrayAdapter<>(context,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        regionLabels);
        dropDown.setAdapter(dropdownAdapter);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, AddPlant.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item.setValue((String) adapterView.getSelectedItem());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        System.out.println("nothing selected");
    }
}
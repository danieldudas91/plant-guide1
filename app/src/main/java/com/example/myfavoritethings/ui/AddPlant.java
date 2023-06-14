package com.example.myfavoritethings.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfavoritethings.R;
import com.example.myfavoritethings.model.Plant;
import com.example.myfavoritethings.viewmodel.PlantViewModel;

public class AddPlant extends AppCompatActivity {

    private EditText nameInput;
    private EditText scientificNameInput;
    private EditText descriptionInput;
    private EditText pictureUrlInput;

    private PlantViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
        nameInput = findViewById(R.id.name_input);
        scientificNameInput = findViewById(R.id.scientific_name_input);
        descriptionInput = findViewById(R.id.description_input);
        pictureUrlInput = findViewById(R.id.image_input);
        viewModel = new PlantViewModel(getApplication());
    }

    public void addNewPlant(View view){
        String name = nameInput.getText().toString();
        String description = descriptionInput.getText().toString();
        String scientificName = scientificNameInput.getText().toString();
        String pictureUrl = pictureUrlInput.getText().toString();
        Context context = getApplicationContext();
        int toastLength = Toast.LENGTH_LONG;
        if(name.equals("") || description.equals("") || scientificName.equals("")){
            Toast toast = Toast.makeText(context, "You must enter a plant name, scientific name and description!", toastLength);
            toast.show();
        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            viewModel.insert(new Plant(name, scientificName, pictureUrl, description));
            startActivity(intent);
        }
    }
}
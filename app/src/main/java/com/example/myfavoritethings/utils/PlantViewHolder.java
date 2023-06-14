package com.example.myfavoritethings.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavoritethings.R;
import com.squareup.picasso.Picasso;

public class PlantViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView description;
    private final ImageView imageView;
    private PlantOnClickListener onclickListener;


    public PlantViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
        this.description = itemView.findViewById(R.id.description);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.onclickListener = new PlantOnClickListener();
        itemView.setOnClickListener(onclickListener);
    }

    public void bind(String name, String scientificName, String description, String imageUrl, int id){
        if(imageUrl.equals("")){
            imageUrl = "https://www.creativefreedom.co.uk/wp-content/uploads/2013/03/00-android-4-0_icons.png";
        }
        this.name.setText(name);
        this.description.setText(description);
        loadImage(imageUrl);
        onclickListener.setScientificName(scientificName);
        onclickListener.setDescription(description);
        onclickListener.setName(name);
        onclickListener.setImageUrl(imageUrl);
        onclickListener.setId(id);
    }

    public static PlantViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new PlantViewHolder(view);
    }

    private void loadImage(String imageUrl){
        Picasso.get()
                .load(imageUrl)
                .resize(48, 48)
                .centerCrop()
                .into(imageView);
    }

}


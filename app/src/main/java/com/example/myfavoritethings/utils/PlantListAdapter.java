package com.example.tripplanner.utils;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.myfavoritethings.model.Plant;
import com.example.myfavoritethings.utils.PlantViewHolder;

public class PlantListAdapter extends ListAdapter<Plant, PlantViewHolder> {

    public PlantListAdapter(@NonNull DiffUtil.ItemCallback<Plant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PlantViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant current = getItem(position);
        holder.bind(current.getName(), current.getScientificName(), current.getDescription(), current.getPictureUrl(), current.getId());
    }


    public static class PlantDiff extends DiffUtil.ItemCallback<Plant> {


        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
package com.example.myfavoritethings;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.WordViewHolder> {

    private LinkedList<String> list;
    private LayoutInflater inflater;

    public ListAdapter(Context context, LinkedList<String> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    public void setList(LinkedList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new WordViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
            String current = list.get(position);
            wordViewHolder.wordItemView.setText(current);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        private ListAdapter listAdapter;
        public TextView wordItemView;

        public WordViewHolder(@NonNull View itemView, ListAdapter listAdapter) {
            super(itemView);
            this.listAdapter = listAdapter;
            wordItemView = itemView.findViewById(R.id.word);
        }
    }
}

package com.example.myfavoritethings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private LinkedList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        list = createAndFillList();
        recyclerView = findViewById(R.id.recycler_view);
        listAdapter =new ListAdapter(this, list);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public LinkedList<String> createAndFillList(){
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast("Element" + i);
        }
        return list;
    }
}
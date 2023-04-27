package com.example.myfavoritethings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private LinkedList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        list = new LinkedList<>();
        recyclerView = findViewById(R.id.recycler_view);
        listAdapter = new ListAdapter(getApplicationContext(), list);
        initRecyclerView(listAdapter);
        fetchData();
    }

    private void initRecyclerView(ListAdapter listAdapter) {
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public LinkedList<String> createAndFillList(){
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast("Element" + i);
        }
        return list;
    }

    public void fetchData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.npoint.io/da5a5926e7caa3d1a8c9";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSON(response);
                        listAdapter.setList(list);
                        initRecyclerView(listAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    private void parseJSON(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                list.addLast(user.getString("name") + " , " + user.getString("age"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
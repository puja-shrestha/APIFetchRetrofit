package com.example.puza.evolve_android_assignment.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.puza.evolve_android_assignment.R;
import com.example.puza.evolve_android_assignment.adapter.RecyclerViewAdapter;
import com.example.puza.evolve_android_assignment.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        itemArrayList = new ArrayList<Item>();
    }
}

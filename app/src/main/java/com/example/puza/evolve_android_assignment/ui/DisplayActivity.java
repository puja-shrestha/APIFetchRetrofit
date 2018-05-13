package com.example.puza.evolve_android_assignment.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.puza.evolve_android_assignment.R;
import com.example.puza.evolve_android_assignment.adapter.DisplayRecyclerAdapter;
import com.example.puza.evolve_android_assignment.model.DisplayItem;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DisplayRecyclerAdapter adapter;
    private ArrayList<DisplayItem> displayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerDisplay);

        displayItems = new ArrayList<DisplayItem>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

    }
}
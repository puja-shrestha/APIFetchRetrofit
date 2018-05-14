package com.example.puza.evolve_android_assignment.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.puza.evolve_android_assignment.Interface.Api;
import com.example.puza.evolve_android_assignment.Interface.DisplayApi;
import com.example.puza.evolve_android_assignment.R;
import com.example.puza.evolve_android_assignment.adapter.DisplayRecyclerAdapter;
import com.example.puza.evolve_android_assignment.model.DisplayItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DisplayRecyclerAdapter adapter;
    private ArrayList<DisplayItem> displayItems;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        if (getIntent().getExtras()!=null)
        {
            id = getIntent().getExtras().getString("id");
            getDisplayData(id);
        }

        recyclerView = (RecyclerView)findViewById(R.id.recyclerDisplay);

        displayItems = new ArrayList<DisplayItem>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

    }


    public void getDisplayData(String id){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DisplayApi api = retrofit.create(DisplayApi.class);

        Call<List<DisplayItem>> call = api.getDisplayApi(id);

        call.enqueue(new Callback<List<DisplayItem>>() {
            @Override
            public void onResponse(Call<List<DisplayItem>> call, Response<List<DisplayItem>> response) {


                List<DisplayItem> displayItems = response.body();

                adapter = new DisplayRecyclerAdapter(DisplayActivity.this, displayItems);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<DisplayItem>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
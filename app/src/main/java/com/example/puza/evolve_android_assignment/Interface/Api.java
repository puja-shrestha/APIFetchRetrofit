package com.example.puza.evolve_android_assignment.Interface;

import com.example.puza.evolve_android_assignment.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Item>> getApi();
}

package com.example.puza.evolve_android_assignment.Interface;

import com.example.puza.evolve_android_assignment.model.DisplayItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DisplayApi {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts/{id}/comments")
    Call<List<DisplayItem>> getDisplayApi(@Path("id") String id);
}

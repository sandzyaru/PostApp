package com.example.postapp;

import android.app.Application;

import com.example.postapp.data.remote.PostApi;
import com.example.postapp.data.remote.PostApiClient;
import com.example.postapp.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient client;
    public static PostApi api;
    public static PostApiClient postApiClient;
    @Override
    public void onCreate() {
        super.onCreate();
        client = new RetrofitClient();
        api= client.createApi();
        postApiClient= new PostApiClient(api);
    }
}

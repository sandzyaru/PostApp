package com.example.postapp.data.remote;

import com.example.postapp.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostApiClient {
    private PostApi api;
    public PostApiClient(PostApi api){
        this.api=api;
    }
    public void getPosts (CustomRequestCallback<List<Post>> callback){
        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful() && response.body() !=null){
                    callback.onSuccess(response.body());
                }else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });

    }
     public interface CustomRequestCallback <DATA>{
        void onSuccess (DATA data);
        void onFailure (String msg);
    }
}

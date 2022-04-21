package com.example.postapp.data.remote;

import com.example.postapp.data.models.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> getPosts();


    @POST ("/posts")
    Call <Post> createPost(@Body Post post);
    @PUT ("/posts")
    Call<ResponseBody> updatePost(int id, Post post);
    @DELETE("/posts/{id}")
    Call<ResponseBody> deletePost(@Path("id") int id);
}

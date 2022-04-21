package com.example.postapp;

import com.example.postapp.data.models.Post;

public interface OnclickListener {
    void onItemClick(Post post);
    void onItemLongClick(Post post);

}

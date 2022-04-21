package com.example.postapp.ui.posts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapp.App;
import com.example.postapp.OnclickListener;
import com.example.postapp.data.models.Post;
import com.example.postapp.databinding.ItemPostBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts = new ArrayList<>();
    private OnclickListener onclickListener;
    HashMap<Integer, String> hashMap = new HashMap<>();
    public void setOnClickListener(OnclickListener onClickListener) {
        this.onclickListener = onClickListener;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding=ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));
        holder.hashmap();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }



    protected  class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;
        public PostViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
        public void onBind (Post post){
            binding.tvUserId.setText(String.valueOf(post.getUserId()));
            binding.tvTitle.setText(post.getTitle());
            binding.tvContent.setText(post.getContent());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onclickListener.onItemClick(post);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onclickListener.onItemLongClick(post);
                    return true;
                }
            });

        }

        public void hashmap() {
            hashMap.put(1, "Ислам");
            hashMap.put(2, "Юнус");
            hashMap.put(3, "Матай");
            hashMap.put(4, "Марат");
            hashMap.put(5, "Санжар");
            hashMap.put(6, "Элмурод");
            hashMap.put(7, "Нурмухаммед");
            hashMap.put(8, "Арстанбек");
            hashMap.put(9, "Дастан");
            hashMap.put(10, "Бексултан");
            hashMap.put(11, "Гоша");
        }
    }
}

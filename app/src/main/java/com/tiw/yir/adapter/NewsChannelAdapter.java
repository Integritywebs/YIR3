package com.tiw.yir.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.NewsChannelModal;

import java.util.List;

public class NewsChannelAdapter extends RecyclerView.Adapter<NewsChannelAdapter.NewsChannelViewHolder> {
    List<NewsChannelModal> newsChannelModalList;
    Activity context;

    public NewsChannelAdapter(List<NewsChannelModal> newsChannelModalList, Activity context) {
        this.newsChannelModalList = newsChannelModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsChannelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_channel_items,null);

        return new NewsChannelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsChannelViewHolder holder, int position) {

        String newsName = newsChannelModalList.get(position).getNews_channel();

        holder.bind(newsName);

    }

    @Override
    public int getItemCount() {
        return newsChannelModalList.size();
    }

    public class NewsChannelViewHolder extends RecyclerView.ViewHolder{

        TextView newsName;

        public NewsChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            newsName = itemView.findViewById(R.id.news_name);

        }
        public void bind(final String name){
            newsName.setText(name);
        }
    }
}

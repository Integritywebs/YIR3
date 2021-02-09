package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrendingFeedAdapter extends RecyclerView.Adapter<TrendingFeedAdapter.TrendingFeedViewHolder> {

    @NonNull
    @Override
    public TrendingFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingFeedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TrendingFeedViewHolder extends RecyclerView.ViewHolder {
        public TrendingFeedViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

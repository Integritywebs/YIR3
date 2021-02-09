package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MostLikeFeedAdapter extends RecyclerView.Adapter<MostLikeFeedAdapter.MostLikeFeedViewHolder> {


    @NonNull
    @Override
    public MostLikeFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MostLikeFeedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MostLikeFeedViewHolder extends RecyclerView.ViewHolder {
        public MostLikeFeedViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

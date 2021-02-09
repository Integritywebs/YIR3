package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogDateAdapter extends RecyclerView.Adapter<BlogDateAdapter.BlogDateViewHolder> {
    @NonNull
    @Override
    public BlogDateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BlogDateViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class BlogDateViewHolder extends RecyclerView.ViewHolder {

        public BlogDateViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogWhatsNewAdapter extends RecyclerView.Adapter<BlogWhatsNewAdapter.BlogWhatsNewViewHolder> {
    @NonNull
    @Override
    public BlogWhatsNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BlogWhatsNewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BlogWhatsNewViewHolder extends RecyclerView.ViewHolder {
        public BlogWhatsNewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

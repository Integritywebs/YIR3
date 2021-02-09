package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class WhatsNewAdapter extends RecyclerView.Adapter<WhatsNewAdapter.WhatsNewViewHolder> {
    @NonNull
    @Override
    public WhatsNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WhatsNewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WhatsNewViewHolder extends RecyclerView.ViewHolder {
        public WhatsNewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

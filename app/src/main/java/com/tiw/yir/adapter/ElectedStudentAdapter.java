package com.tiw.yir.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElectedStudentAdapter extends RecyclerView.Adapter<ElectedStudentAdapter.ElectedStudentViewHolder> {

    @NonNull
    @Override
    public ElectedStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ElectedStudentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ElectedStudentViewHolder extends RecyclerView.ViewHolder {
        public ElectedStudentViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.tiw.yir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.ScholarshipAwardResponse;

import java.util.List;


public class ScholarshipAwardAdapter extends RecyclerView.Adapter<ScholarshipAwardAdapter.ScholarshipAwardViewHolder> {

    Context context;
    List<ScholarshipAwardResponse> scholarshipAwardResponses;
    private OnItemClick onItemClick;

    public ScholarshipAwardAdapter(Context context, List<ScholarshipAwardResponse> scholarshipAwardResponses, OnItemClick onItemClick) {
        this.context = context;
        this.scholarshipAwardResponses = scholarshipAwardResponses;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ScholarshipAwardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ScholarshipAwardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ScholarshipAwardViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView mobile;
        TextView email;
        public ScholarshipAwardViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.round_image);
            name = itemView.findViewById(R.id.name);
            mobile = itemView.findViewById(R.id.mobile);
           // email = itemView.findViewById(R.id.email);
        }
    }

    public interface OnItemClick{
        void itemClick(ScholarshipAwardResponse modaldata);
    }
}

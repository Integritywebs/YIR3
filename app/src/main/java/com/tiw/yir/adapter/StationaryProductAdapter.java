package com.tiw.yir.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.StationaryProductModal;

import java.util.List;

public class StationaryProductAdapter extends RecyclerView.Adapter<StationaryProductAdapter.StationaryProductViewHolder> {

    List<StationaryProductModal> stationaryProductModalList;
    Activity context;

    public StationaryProductAdapter(List<StationaryProductModal> stationaryProductModalList, Activity context) {
        this.stationaryProductModalList = stationaryProductModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public StationaryProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stationary_items,null);
        return new StationaryProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationaryProductViewHolder holder, int position) {
        String s_title = stationaryProductModalList.get(position).getStationary_title();
        holder.bind(s_title);

    }

    @Override
    public int getItemCount() {
        return stationaryProductModalList.size();
    }

    public class StationaryProductViewHolder extends RecyclerView.ViewHolder{
        ImageView stationary_image;
        TextView stationary_title;
        TextView stationary_price;
        TextView stationary_pieces;
        public StationaryProductViewHolder(@NonNull View itemView) {
            super(itemView);
            stationary_image = itemView.findViewById(R.id.stationary_img);
            stationary_title = itemView.findViewById(R.id.stationary_title);
            stationary_price = itemView.findViewById(R.id.stationary_price);
            stationary_pieces = itemView.findViewById(R.id.stationary_pieces);
        }

        public void bind(final String title){
            stationary_title.setText(title);
        }

    }
}

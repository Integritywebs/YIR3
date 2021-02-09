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
import com.tiw.yir.model.ValuableFeedBackModals;

import java.util.List;


public class ValuableFeedBackAdapter extends RecyclerView.Adapter<ValuableFeedBackAdapter.ValuableFeedBackViewholder> {

    List<ValuableFeedBackModals> valuableFeedBackModalsList;
    Activity context;

    public ValuableFeedBackAdapter(List<ValuableFeedBackModals> valuableFeedBackModalsList, Activity context) {
        this.valuableFeedBackModalsList = valuableFeedBackModalsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ValuableFeedBackViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_items,null);
        return new ValuableFeedBackViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ValuableFeedBackViewholder holder, int position) {

        String name  = valuableFeedBackModalsList.get(position).getName();

        ((ValuableFeedBackViewholder)holder).bind(name);

    }

    @Override
    public int getItemCount() {
        return valuableFeedBackModalsList.size();
    }

    public class ValuableFeedBackViewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtname;
        TextView headline;
        TextView news;
        ImageView like;
        ImageView share;
        ImageView comments;


        public ValuableFeedBackViewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            txtname = itemView.findViewById(R.id.name);
            headline = itemView.findViewById(R.id.headlines);
            news = itemView.findViewById(R.id.news);
            like = itemView.findViewById(R.id.img_like);
            comments = itemView.findViewById(R.id.img_comment);
            share = itemView.findViewById(R.id.img_share);
        }

        public void bind(final String name){
            txtname.setText(name);
        }
    }
}

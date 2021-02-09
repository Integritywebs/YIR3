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
import com.tiw.yir.model.EventModal;

import java.util.List;



public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    Activity context;
    List<EventModal> eventModals;
    int selectedPosition = 1;

    public EventAdapter(Activity context, List<EventModal> eventModals) {
        this.context = context;
        this.eventModals = eventModals;

    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_items, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventModal modalItems = eventModals.get(position);


        ((EventViewHolder)holder).bind(modalItems);
    }

    @Override
    public int getItemCount() {
        return eventModals.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView t_date;
        TextView t_Topic;
        TextView t_news;
        public EventViewHolder(@NonNull View itemView) {

            super(itemView);

            img = itemView.findViewById(R.id.event_img);
            t_date = itemView.findViewById(R.id.date);
            t_Topic = itemView.findViewById(R.id.topic);
            t_news = itemView.findViewById(R.id.event_news);
        }

        public void bind(EventModal modal){
            t_date.setText(modal.getDate());
        }
    }

  /*  @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_items, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        EventModal modalItems = eventModals.get(position);


        ((EventViewHolder)holder).bind(modalItems);

    }

    @Override
    public int getItemCount() {
        return eventModals.size();
    }*/
}

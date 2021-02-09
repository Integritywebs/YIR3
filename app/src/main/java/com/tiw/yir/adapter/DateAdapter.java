package com.tiw.yir.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.DateModals;

import java.util.List;


public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private Activity context;
    List<DateModals> dateModalsList;

    public DateAdapter(Activity context, List<DateModals> dateModalsList) {
        this.context = context;
        this.dateModalsList = dateModalsList;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_items, null);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {

        DateModals currentsItem = dateModalsList.get(position);

        ((DateViewHolder)holder).bind(currentsItem);

    }

    @Override
    public int getItemCount() {
        return dateModalsList.size();
    }

  /*  @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_items, null);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        DateModals currentsItem = dateModalsList.get(position);

        ((DateViewHolder)holder).bind(currentsItem);

    }

    @Override
    public int getItemCount() {
        return dateModalsList.size();
    }*/

    public class DateViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layoutbg;
        private TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutbg = itemView.findViewById(R.id.layout_bg);
            date = itemView.findViewById(R.id.date);
        }
        public void bind(DateModals dateModals){
            date.setText(dateModals.getDate());
        }

    }
}

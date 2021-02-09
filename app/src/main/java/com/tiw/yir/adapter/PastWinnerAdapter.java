package com.tiw.yir.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.PastWinnerResponse;

import java.util.List;

public class PastWinnerAdapter extends RecyclerView.Adapter<PastWinnerAdapter.PastWinnerViewHolder> {

    Context context;
    List<PastWinnerResponse.Data> responseList;
    private OnItemClick onItemClick;

    public PastWinnerAdapter(Context context, List<PastWinnerResponse.Data> responseList, OnItemClick onItemClick) {
        this.context = context;
        this.responseList = responseList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public PastWinnerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.past_winner_items,viewGroup,false);
      return new PastWinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastWinnerViewHolder holder, int position) {

        final PastWinnerResponse.Data modal = responseList.get(position);

        holder.txt_name.setText(modal.getFullName());
        holder.txt_date.setText(modal.getDob());
        holder.txt_email.setText(modal.getEmail());
        holder.txt_mobile.setText(modal.getMobile());

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public class PastWinnerViewHolder extends RecyclerView.ViewHolder{

        TextView txt_name;
        TextView txt_mobile;
        TextView txt_email;
        TextView txt_date;


        public PastWinnerViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.et_name);
            txt_mobile = itemView.findViewById(R.id.et_mobile);
            txt_email = itemView.findViewById(R.id.et_email);
            txt_date = itemView.findViewById(R.id.et_date);


        }
    }

    public interface OnItemClick{
        void itemClick(PastWinnerResponse.Data modalData);
    }
}

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
import com.tiw.yir.model.EMagazineModal;

import java.util.List;

public class EMagazineAdapter extends RecyclerView.Adapter<EMagazineAdapter.EMagazineViewHolder> {

    List<EMagazineModal> eMagazineModalList;
    Activity context;

    public EMagazineAdapter(List<EMagazineModal> eMagazineModalList, Activity context) {
        this.eMagazineModalList = eMagazineModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public EMagazineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emagazine_download_items,null);
       return new EMagazineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EMagazineViewHolder holder, int position) {

        String c_name = eMagazineModalList.get(position).getMagazine_comapany_name();

        holder.bind(c_name);

    }

    @Override
    public int getItemCount() {
        return eMagazineModalList.size();
    }

    public class EMagazineViewHolder extends RecyclerView.ViewHolder {

        ImageView magazine_image;
        TextView magazine_company_name;
        TextView magazine_title;
        TextView magazine_price;
        TextView magazine_status;
        TextView magazine_content;

        public EMagazineViewHolder(@NonNull View itemView) {
            super(itemView);
            magazine_image = itemView.findViewById(R.id.e_magazine_img);
            magazine_company_name = itemView.findViewById(R.id.e_mag_company_name);
            magazine_title = itemView.findViewById(R.id.mag_title);
            magazine_price = itemView.findViewById(R.id.magazine_price);
            magazine_status = itemView.findViewById(R.id.magazine_status);
            magazine_content = itemView.findViewById(R.id.magazine_content);
        }
        public void bind(final String comapny_name){
            magazine_company_name.setText(comapny_name);
        }
    }
}

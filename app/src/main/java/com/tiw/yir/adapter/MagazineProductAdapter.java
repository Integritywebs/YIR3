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
import com.tiw.yir.model.MagazineProductModal;

import java.util.List;


public class MagazineProductAdapter extends RecyclerView.Adapter<MagazineProductAdapter.MagazineProductViewHolder> {

    List<MagazineProductModal> magazineProductModalList;
    Activity activity;

    public MagazineProductAdapter(List<MagazineProductModal> magazineProductModalList, Activity activity) {
        this.magazineProductModalList = magazineProductModalList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MagazineProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.magzines_product_items,null);
        return new MagazineProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MagazineProductViewHolder holder, int position) {

        String m_title = magazineProductModalList.get(position).getMagazine_title();

        holder.bind(m_title);

    }

    @Override
    public int getItemCount() {
        return magazineProductModalList.size();
    }

    public class MagazineProductViewHolder extends RecyclerView.ViewHolder{
        ImageView magazine_image;
        TextView magazine_title;
        TextView magazine_price;
        TextView magazine_download;

        public MagazineProductViewHolder(@NonNull View itemView) {
            super(itemView);
            magazine_image = itemView.findViewById(R.id.magzine_img);
            magazine_title = itemView.findViewById(R.id.magzine_title);
            magazine_price = itemView.findViewById(R.id.magazine_price);
            magazine_download = itemView.findViewById(R.id.magzine_download);
        }

        public void bind(final String title){
            magazine_title.setText(title);
        }
    }
}

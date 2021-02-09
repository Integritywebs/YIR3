package com.tiw.yir.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.GroupModel;
import com.tiw.yir.model.Homemodel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder> {

    private Context context;
    private List<Homemodel> albumList;

    public HomeAdapter(Context context, List<Homemodel> albumList) {
        this.context = context;
        this.albumList = albumList;
    }


    @NonNull
    @Override
    public HomeAdapter.HomeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_home, parent, false);
        return new HomeAdapter.HomeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeAdapterViewHolder holder, int position) {
        holder.name.setText(albumList.get(position).getName());
        holder.textnumber.setText(albumList.get(position).getCount());
        holder.cardview.setCardBackgroundColor(Color.parseColor("#b70505"));
            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "You are joined", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class HomeAdapterViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.image)
        CircleImageView image;
        @BindView(R.id.textnumber)
        TextView textnumber;

        @BindView(R.id.cardview)
        CardView cardview;
        public HomeAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
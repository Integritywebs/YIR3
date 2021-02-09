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
import com.tiw.yir.model.NewGroupModal;

import java.util.List;


public class NewGroup extends RecyclerView.Adapter<NewGroup.NewGroupViewHolder> {

    Activity context;
    List<NewGroupModal> groupModalList;

    public NewGroup(Activity context, List<NewGroupModal> groupModalList) {
        this.context = context;
        this.groupModalList = groupModalList;
    }

    @NonNull
    @Override
    public NewGroupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_group_items,null);
        return new NewGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewGroupViewHolder holder, int position) {


        NewGroupModal modalItems = groupModalList.get(position);

        ((NewGroupViewHolder)holder).bind(modalItems);

    }

    @Override
    public int getItemCount() {
        return groupModalList.size();
    }

  /*  @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_group_items,null);
        return new NewGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        NewGroupModal modalItems = groupModalList.get(position);

        ((NewGroupViewHolder)holder).bind(modalItems);

    }

    @Override
    public int getItemCount() {
        return groupModalList.size();
    }*/

    public class NewGroupViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView headline;
        TextView news;
        ImageView like;
        ImageView share;
        ImageView comments;
        public NewGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            headline = itemView.findViewById(R.id.headlines);
            news = itemView.findViewById(R.id.news);
            like = itemView.findViewById(R.id.img_like);
            comments = itemView.findViewById(R.id.img_comment);
            share = itemView.findViewById(R.id.img_share);
        }

        public void bind(NewGroupModal newGroupModal){
            name.setText(newGroupModal.getName());
        }
    }

}

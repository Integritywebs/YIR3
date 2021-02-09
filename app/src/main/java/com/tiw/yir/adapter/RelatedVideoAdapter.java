package com.tiw.yir.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.RelatedFeedModals;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RelatedVideoAdapter extends RecyclerView.Adapter<RelatedVideoAdapter.RelatedVideoViewHolder> {

    Activity context;
    List<RelatedFeedModals> relatedFeedModalsList;

    public RelatedVideoAdapter(Activity context, List<RelatedFeedModals> relatedFeedModalsList) {
        this.context = context;
        this.relatedFeedModalsList = relatedFeedModalsList;
    }

    @NonNull
    @Override
    public RelatedVideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_items, null);
        return new RelatedVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedVideoViewHolder holder, int position) {
        int videoImg = relatedFeedModalsList.get(position).getVideo_image();
        int image = relatedFeedModalsList.get(position).getPlay_img();

        holder.bind(videoImg,image);

    }

    @Override
    public int getItemCount() {
        return relatedFeedModalsList.size();
    }

    public class RelatedVideoViewHolder extends RecyclerView.ViewHolder{
        CircleImageView videoImage;
        ImageView play_image;

        public RelatedVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImage = itemView.findViewById(R.id.related_video_image);
            play_image = itemView.findViewById(R.id.play_button);

        }
        public void bind(final int video_img,final int play_img){
            videoImage.setImageResource(video_img);
            play_image.setImageResource(play_img);
        }
    }

 /*   @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_items, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }*/
}

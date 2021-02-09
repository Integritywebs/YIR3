package com.tiw.yir.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.model.RecentFeedModals;

import java.util.List;


public class RecentFeedAdapter extends RecyclerView.Adapter<RecentFeedAdapter.ViewHolder> {

    List<RecentFeedModals> recentFeedModalsList;
    Activity context;

    public RecentFeedAdapter(List<RecentFeedModals> recentFeedModalsList, Activity context) {
        this.recentFeedModalsList = recentFeedModalsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trending_items, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int img = recentFeedModalsList.get(position).getVideo_image();

       int image = recentFeedModalsList.get(position).getPlay_img();

        holder.bind(img,image);


    }

    @Override
    public int getItemCount() {
        return recentFeedModalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView videoImage;
        ImageView play_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoImage = itemView.findViewById(R.id.trending_video_image);
            play_image = itemView.findViewById(R.id.play_button);

        }
        public void bind(final int video_img,final int play_img){
            videoImage.setImageResource(video_img);
            play_image.setImageResource(play_img);

        }

    }
}

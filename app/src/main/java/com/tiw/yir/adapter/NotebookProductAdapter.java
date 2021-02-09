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
import com.tiw.yir.model.NotebookProductModal;

import java.util.List;


public class NotebookProductAdapter extends RecyclerView.Adapter<NotebookProductAdapter.NotebookViewHolder> {

    List<NotebookProductModal> notebookProductModalList;
    Activity context;

    public NotebookProductAdapter(List<NotebookProductModal> notebookProductModalList, Activity context) {
        this.notebookProductModalList = notebookProductModalList;
        this.context = context;
    }

    @NonNull
    @Override
    public NotebookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notebook_items,null);
        return new NotebookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotebookViewHolder holder, int position) {
        String n_title = notebookProductModalList.get(position).getNotebook_title();

        holder.bind(n_title);

    }

    @Override
    public int getItemCount() {
        return notebookProductModalList.size();
    }

    public class NotebookViewHolder extends RecyclerView.ViewHolder{
        ImageView notebook_image;
        TextView notebook_title;
        TextView notebook_price;
        TextView notebook_pages;

        public NotebookViewHolder(@NonNull View itemView) {
            super(itemView);
            notebook_image = itemView.findViewById(R.id.notebook_img);
            notebook_title = itemView.findViewById(R.id.notebook_title);
            notebook_price = itemView.findViewById(R.id.notebook_price);
            notebook_pages = itemView.findViewById(R.id.notebook_pages);

        }
        public void bind(final String title){
            notebook_title.setText(title);
        }
    }
}

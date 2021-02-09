package com.tiw.yir.adapter;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.fragment.ElectedStudentsFragment;
import com.tiw.yir.fragment.MonthlyScholarshipFragment;
import com.tiw.yir.fragment.ScholarshipAward;
import com.tiw.yir.fragment.TotalApplicationFragment;
import com.tiw.yir.model.AnnouncementModals;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>  {


    List<AnnouncementModals> modalsList;
    Activity context;
    FragmentManager fragmentManager;


    public AnnouncementAdapter(List<AnnouncementModals> modalsList, Activity context, FragmentManager fragmentManager) {
        this.modalsList = modalsList;
        this.context = context;
        this.fragmentManager=fragmentManager;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_tablayout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final int a_image = modalsList.get(position).getImage();
        final String a_name = modalsList.get(position).getName();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                int selectedItem = -1;
                Log.d(TAG, "onClick: inside click from view holder");
                // Make sure your position is available on your list.

                if (position != RecyclerView.NO_POSITION) {
                    if (position == selectedItem) {
                        return;// Here, I don't want to generate a click event on an already selected item.
                    }

                    int currentSelected = selectedItem;// Create a temp var to deselect an existing one, if any.
                    selectedItem = position;// Check item.

                    if (currentSelected != -1) {
                        notifyItemChanged(currentSelected);// Deselected the previous item.
                    }
                    notifyItemChanged(selectedItem);// Select the current item.
                }
                if (position == selectedItem) {
                    // Do action when the item is selected. Change background.
                    switch (position){
                        case 0:
                            Log.d(TAG, "onClick: case 0");
                            holder.bind(R.drawable.elected_student_1,a_name);
                            ElectedStudentsFragment nextFrag = new ElectedStudentsFragment();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.announcement_container, nextFrag, "findThisFragment")
                                    .addToBackStack(null)
                                    .commit();
                            break;
                        case 1:
                            holder.bind(R.drawable.scholarship_awards_1,a_name);
                            ScholarshipAward nextFrag1 = new ScholarshipAward();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.announcement_container, nextFrag1, "findThisFragment")
                                    .addToBackStack(null)
                                    .commit();
                            break;
                        case 2:
                            holder.bind(R.drawable.monthly_awards_1,a_name);
                            MonthlyScholarshipFragment nextFrag3 = new MonthlyScholarshipFragment();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.announcement_container, nextFrag3, "findThisFragment")
                                    .addToBackStack(null)
                                    .commit();
                            break;
                        case 3:

                            TotalApplicationFragment nextFrag4= new TotalApplicationFragment();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.announcement_container, nextFrag4, "findThisFragment")
                                    .addToBackStack(null)
                                    .commit();
                            holder.bind(R.drawable.total_application_1,a_name);
                            break;
                        default:
                            Log.d(TAG, "onClick: default"+position);
                    }
                } else {
                    // Or on no selected otherwise.
                    holder.bind(a_image,a_name);

                }
            }
        });

        holder.bind(a_image,a_name);
    }

    @Override
    public int getItemCount() {
        return modalsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {


        CircleImageView imageView;
        TextView name;
        private ItemClickListener itemClickListener;

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img1);
            name = itemView.findViewById(R.id.textView);


        }

        public void bind(final int image,final String a_name){
            imageView.setImageResource(image);
            name.setText(a_name);
        }

        public void bindImage(final int image){
            imageView.setImageResource(image);
        }

    }

}

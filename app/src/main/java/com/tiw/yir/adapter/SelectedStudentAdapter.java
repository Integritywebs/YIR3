package com.tiw.yir.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.activity.ElectionPollingActivity;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.ElectionDataResponse;
import com.tiw.yir.model.GiveVoteResponse;
import com.tiw.yir.model.GroupModel;
import com.tiw.yir.model.PastWinnerResponse;
import com.tiw.yir.model.SelectedStudentModal;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public  class SelectedStudentAdapter extends RecyclerView.Adapter<SelectedStudentAdapter.SelectedStudentsViewHolder> {

    Activity context;
    List<PastWinnerResponse.Data> studentModalList;
    OnItemClick onItemClick;
    SaveSharedPreference preference;

    public SelectedStudentAdapter(Activity context, List<PastWinnerResponse.Data> studentModalList, OnItemClick onItemClick) {
        this.context = context;
        this.studentModalList = studentModalList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public SelectedStudentsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.selected_students_items,viewGroup,false);
        return new SelectedStudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedStudentsViewHolder holder, int position) {

        PastWinnerResponse.Data modal = studentModalList.get(position);

        holder.name.setText(modal.getFullName());
        holder.mobile.setText(modal.getMobile());
        holder.group.setText(modal.getElectionGroup());

        holder.vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.showProgressDialog(context);
                String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);

                MyApiEndpointInterface service = APIService.getClient().create(MyApiEndpointInterface.class);
                Call<GiveVoteResponse> call = service.give_vote(token,modal.getId());
                call.enqueue(new Callback<GiveVoteResponse>() {
                    @Override
                    public void onResponse(Call<GiveVoteResponse> call, Response<GiveVoteResponse> response) {

                        try {

                            Common.dismissProgressDialog();
                            Toast.makeText(context,"Thank You for voting",Toast.LENGTH_LONG).show();
                            holder.vote.setVisibility(view.INVISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//

                    }

                    @Override
                    public void onFailure(Call<GiveVoteResponse> call, Throwable t) {

                        Common.dismissProgressDialog();
                        Log.d("jdus", "onFailure" + t.toString());
                        Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentModalList.size();
    }

    public class SelectedStudentsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name;
        TextView mobile;
        TextView group;
        TextView vote;
        public SelectedStudentsViewHolder(@NonNull View itemView) {

            super(itemView);
            preference = new SaveSharedPreference(context);
            //image = itemView.findViewById(R.id.round_image);
            name = itemView.findViewById(R.id.name);
            mobile = itemView.findViewById(R.id.mobile);
            group = itemView.findViewById(R.id.group);
            vote = itemView.findViewById(R.id.vote);

        }

    }
    public interface OnItemClick{
        void itemClick(PastWinnerResponse.Data modalData);
    }


}

package com.tiw.yir.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.activity.ScholerShipActivity;
import com.tiw.yir.adapter.SelectedStudentAdapter;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.ApiClient;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.ScholarshipAwardResponse;
import com.tiw.yir.model.SelectedStudentModal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScholarshipAward extends Fragment {
    RecyclerView scholarshipAward_rv;
    List<SelectedStudentModal> studentModals = new ArrayList<>();
    ProgressDialog progressDialog;
    SaveSharedPreference preference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectedStudentModal modal = new SelectedStudentModal();
        modal.setName("Sanjay Kapoor");
        modal.setMobile("+91 8866000015");
        modal.setGroup("MS Group");
        for (int i = 0; i < 5; i++) {
            studentModals.add(modal);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scholarship_award, container, false);

        scholarshipAward_rv = view.findViewById(R.id.scholarship_award_rv);

       // SelectedStudentAdapter adapter = new SelectedStudentAdapter(getActivity(),studentModals);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        scholarshipAward_rv.setLayoutManager(layoutManager);
       // scholarshipAward_rv.setAdapter(adapter);

        getAwardsLists();


        return view;
    }

    private void getAwardsLists() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);
        MyApiEndpointInterface apiServices = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<ScholarshipAwardResponse> call = apiServices.get_scholarship_award(token);
        call.enqueue(new Callback<ScholarshipAwardResponse>() {
            @Override
            public void onResponse(Call<ScholarshipAwardResponse> call, Response<ScholarshipAwardResponse> response) {
                if(response.isSuccessful()) {
                    try {
                        ScholarshipAwardResponse electionDataResponse = response.body();
                        Log.d(getTag(), "onResponse: " + response.message());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {

                }}


            @Override
            public void onFailure(Call<ScholarshipAwardResponse> call, Throwable t) {

            }
        });



    }
}
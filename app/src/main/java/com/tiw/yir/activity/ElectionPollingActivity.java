package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.PastWinnerAdapter;
import com.tiw.yir.adapter.SelectedStudentAdapter;
import com.tiw.yir.controller.PreferenceManager;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.ApiClient;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.PastWinnerResponse;
import com.tiw.yir.model.SelectedStudentModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ElectionPollingActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView backBtn,profileBtn;
    RecyclerView selectedStudents_rv,pastWinner_rv;
    TextView loadMore_txt,gotoform;
    List<PastWinnerResponse.Data> studentModals = new ArrayList<>();
    List<PastWinnerResponse.Data> winnerReponse=new ArrayList<PastWinnerResponse.Data>();
    PastWinnerAdapter winnerAdapter;
    ImageView back_btn;
    SelectedStudentAdapter adapter;
    private LinearLayout coordinator;
    SaveSharedPreference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = new SaveSharedPreference(this);
        setContentView(R.layout.fragment_election_polling);

        SelectedStudentModal modal = new SelectedStudentModal();
        selectedStudents_rv = findViewById(R.id.selected_students_rv);
        pastWinner_rv = findViewById(R.id.past_winner_rv);
        gotoform = findViewById(R.id.gotoform);
        coordinator = findViewById(R.id.constrainLayout);
        gotoform.setOnClickListener(this::onClick);


       adapter = new SelectedStudentAdapter(this, studentModals, new SelectedStudentAdapter.OnItemClick() {
            @Override
            public void itemClick(PastWinnerResponse.Data modalData) {
                startActivity(new Intent(getApplicationContext(),ElectionFormActivity.class));
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        selectedStudents_rv.setLayoutManager(layoutManager);
        selectedStudents_rv.setAdapter(adapter);
        selectedStudentResponse();

        winnerAdapter = new PastWinnerAdapter(this, winnerReponse, new PastWinnerAdapter.OnItemClick() {
            @Override
            public void itemClick(PastWinnerResponse.Data modalData) {

            }
        });
        GridLayoutManager pastlayoutManager = new GridLayoutManager(this,3);
        pastWinner_rv.setLayoutManager(pastlayoutManager);
        pastWinner_rv.setAdapter(winnerAdapter);
        pastWinnerResponse();

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ElectionPollingActivity.this,MainActivity.class);
            }
        });
    }

    private void selectedStudentResponse() {

        Common.showProgressDialog(this);
        String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);
        MyApiEndpointInterface service = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<PastWinnerResponse> call = service.candidate_selected(token);
        call.enqueue(new Callback<PastWinnerResponse>() {
            @Override
            public void onResponse(Call<PastWinnerResponse> call, Response<PastWinnerResponse> response) {

                    try {
                        Common.dismissProgressDialog();
                        coordinator.setVisibility(View.VISIBLE);
                        PastWinnerResponse pastWinnerResponse = response.body();
                        studentModals.clear();
                        if (pastWinnerResponse.getData().size() > 0) {
                            for (int i = 0; i < pastWinnerResponse.getData().size(); i++) {
                                studentModals.add(pastWinnerResponse.getData().get(i));
                            }
                        } else {
                            Toast.makeText(ElectionPollingActivity.this, pastWinnerResponse.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        adapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<PastWinnerResponse> call, Throwable t) {

                Common.dismissProgressDialog();
            }
        });
    }

    public void pastWinnerResponse() {


        Common.showProgressDialog(this);
        String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);
        Log.d(getClass().getName(), "Response" + token);
        String status = "1";

        MyApiEndpointInterface service = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<PastWinnerResponse> call = service.past_winner(token,status);
        call.enqueue(new Callback<PastWinnerResponse>() {
            @Override
            public void onResponse(Call<PastWinnerResponse> call, Response<PastWinnerResponse> response) {
                    try {
                        Common.dismissProgressDialog();
                        coordinator.setVisibility(View.VISIBLE);
                        PastWinnerResponse pastWinnerResponse = response.body();
                        winnerReponse.clear();
                        if (pastWinnerResponse.getData().size() > 0) {
                            for (int i = 0; i < pastWinnerResponse.getData().size(); i++) {
                                winnerReponse.add(pastWinnerResponse.getData().get(i));
                            }
                        } else {
                            Toast.makeText(ElectionPollingActivity.this, pastWinnerResponse.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        winnerAdapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


            }

            @Override
            public void onFailure(Call<PastWinnerResponse> call, Throwable t) {

                Common.dismissProgressDialog();
                Log.d("jdus", "onFailure" + t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onClick(View view) {
        int vId=view.getId();
        if (vId==R.id.gotoform){
            Intent intent=new Intent(ElectionPollingActivity.this,ElectionFormActivity.class);
            startActivity(intent);
        }
    }
}
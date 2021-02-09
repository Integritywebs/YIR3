package com.tiw.yir.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.ValuableFeedBackAdapter;
import com.tiw.yir.model.ValuableFeedBackModals;

import java.util.ArrayList;
import java.util.List;


public class FeedBackActivity extends AppCompatActivity {
    RecyclerView valuableFeedback_rv;
    Activity context;
    ImageView back_btn;
    List<ValuableFeedBackModals> valuableFeedBackModalsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_feed_back);
        ValuableFeedBackModals modal = new ValuableFeedBackModals();
        modal.setName("Vidita Singh,today at 09:40 am");
        for (int i = 0; i < 2; i++) {
            valuableFeedBackModalsList.add(modal);
        }

        valuableFeedback_rv =findViewById(R.id.valuable_feedback_rv);

        ValuableFeedBackAdapter adapter = new ValuableFeedBackAdapter(valuableFeedBackModalsList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
        valuableFeedback_rv.setLayoutManager(layoutManager);
        valuableFeedback_rv.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FeedBackActivity.this,MainActivity.class);
            }
        });

    }
}
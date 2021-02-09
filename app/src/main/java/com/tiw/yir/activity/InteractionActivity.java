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

public class InteractionActivity extends AppCompatActivity {
    Activity context;
    List<ValuableFeedBackModals> valuableFeedBackModalsList = new ArrayList<>();
    RecyclerView interaction_rv;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_interaction);

        inIt();
    }

    private void inIt() {
        ValuableFeedBackModals modal = new ValuableFeedBackModals();
        modal.setName("Vidita Singh,today at 09:40 am");
        for (int i = 0; i < 2; i++) {
            valuableFeedBackModalsList.add(modal);
        }

        interaction_rv = findViewById(R.id.interact_rv);

        ValuableFeedBackAdapter adapter = new ValuableFeedBackAdapter(valuableFeedBackModalsList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        interaction_rv.setLayoutManager(layoutManager);
        interaction_rv.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(InteractionActivity.this,MainActivity.class);
            }
        });
    }


}
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
import com.tiw.yir.adapter.EMagazineAdapter;
import com.tiw.yir.model.EMagazineModal;

import java.util.ArrayList;
import java.util.List;


public class EMagazinesActivity extends AppCompatActivity {

    RecyclerView eMagazine_Rv;
    List<EMagazineModal> eMagazineModalList = new ArrayList<>();
    Activity context;
    ImageView back_btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_e_magazines);
        EMagazineModal modals = new EMagazineModal();
        modals.setMagazine_comapany_name("Production Company");
        for (int i = 0; i < 4; i++){
            eMagazineModalList.add(modals);
        }


        eMagazine_Rv = findViewById(R.id.e_magazines_rv);

        /// EMagazine Download RecyclerView

        EMagazineAdapter adapter = new EMagazineAdapter(eMagazineModalList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        eMagazine_Rv.setLayoutManager(layoutManager);
        eMagazine_Rv.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(EMagazinesActivity.this,MainActivity.class);
            }
        });
    }
}
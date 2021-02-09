package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.DateAdapter;
import com.tiw.yir.adapter.NewGroup;
import com.tiw.yir.model.DateModals;
import com.tiw.yir.model.NewGroupModal;

import java.util.ArrayList;
import java.util.List;


public class PropagandaActivity extends AppCompatActivity {
    ImageView backBtn,profileBtn;
    RecyclerView date_rv,whats_new_rv,news_group_rv;
    ConstraintLayout sortByBtn,load_moreBtn;
    List<DateModals> modals = new ArrayList<>();
    List<NewGroupModal> newsModals = new ArrayList<>();
    ImageView back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_propaganda);
        DateModals dateModals = new DateModals();
        dateModals.setDate("20/08/2020");
        for (int i = 0; i < 3; i++) {
            modals.add(dateModals);
        }

        NewGroupModal newGroupModal = new NewGroupModal();
        newGroupModal.setName("by Tarun Singhal,today at 09:40am");
        for (int i = 0;i < 2; i++){
            newsModals.add(newGroupModal);
        }


        date_rv = findViewById(R.id.date_rv);
        whats_new_rv = findViewById(R.id.whats_new_rv);
        news_group_rv = findViewById(R.id.news_group_rv);


        DateAdapter adapter = new DateAdapter(this,modals);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        date_rv.setLayoutManager(layoutManager);
        date_rv.setAdapter(adapter);

        NewGroup newsAdapter = new NewGroup(this,newsModals);
        LinearLayoutManager newslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        whats_new_rv.setLayoutManager(newslayoutManager);
        whats_new_rv.setAdapter(newsAdapter);

        NewGroup groupAdapter = new NewGroup(this,newsModals);
        LinearLayoutManager grouplayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        news_group_rv.setLayoutManager(grouplayoutManager);
        news_group_rv.setAdapter(groupAdapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PropagandaActivity.this,MainActivity.class);
            }
        });
    }
}
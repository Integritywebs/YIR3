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
import com.tiw.yir.adapter.NewGroup;
import com.tiw.yir.adapter.NewsChannelAdapter;
import com.tiw.yir.model.NewGroupModal;
import com.tiw.yir.model.NewsChannelModal;

import java.util.ArrayList;
import java.util.List;


public class LiveNewsActivity extends AppCompatActivity {
    RecyclerView news_name_rv,news_rv,news_group_rv;

    List<NewsChannelModal> newsChannelModalList = new ArrayList<>();
    Activity context;
    ImageView back_btn;
    List<NewGroupModal> newsModals = new ArrayList<>();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_live_news);
        NewsChannelModal modal = new NewsChannelModal();
        modal.setNews_channel("Zee News");
        for (int i = 0; i < 4;i++){
            newsChannelModalList.add(modal);
        }
        NewGroupModal newGroupModal = new NewGroupModal();
        newGroupModal.setName("by Tarun Singhal,today at 09:40am");
        for (int i = 0;i < 2; i++){
            newsModals.add(newGroupModal);
        }


        news_name_rv = findViewById(R.id.news_name_rv);
        news_rv = findViewById(R.id.news_rv);
        news_group_rv = findViewById(R.id.news_group_rv);

        /// New Channel Name RecyclerView
        NewsChannelAdapter adapter = new NewsChannelAdapter(newsChannelModalList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false);
        news_name_rv.setLayoutManager(layoutManager);
        news_name_rv.setAdapter(adapter);

        ///Channel News RecyclerView
        NewGroup newsAdapter = new NewGroup(this,newsModals);
        LinearLayoutManager newslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        news_rv.setLayoutManager(newslayoutManager);
        news_rv.setAdapter(newsAdapter);


        //// New Group NEws
        NewGroup groupAdapter = new NewGroup(this,newsModals);
        LinearLayoutManager grouplayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        news_group_rv.setLayoutManager(grouplayoutManager);
        news_group_rv.setAdapter(groupAdapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LiveNewsActivity.this,MainActivity.class);
            }
        });
    }
}
package com.tiw.yir.activity;

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
import com.tiw.yir.adapter.DateAdapter;
import com.tiw.yir.adapter.NewGroup;
import com.tiw.yir.model.DateModals;
import com.tiw.yir.model.NewGroupModal;

import java.util.ArrayList;
import java.util.List;


public class BlogActivity extends AppCompatActivity {
    RecyclerView whatsnew_rv;
    RecyclerView date_rv;
    ImageView back_btn;
    List<DateModals> modals = new ArrayList<>();
    List<NewGroupModal> newsModals = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        DateModals dateModals = new DateModals();
        dateModals.setDate("20/08/2020");
        for (int i = 0; i < 3; i++) {
            modals.add(dateModals);
        }

        NewGroupModal newGroupModal = new NewGroupModal();
        newGroupModal.setName("by Tarun Singhal,today at 09:40am");
        for (int i = 0;i < 5; i++){
            newsModals.add(newGroupModal);
        }


        date_rv = findViewById(R.id.date_rv);
        whatsnew_rv = findViewById(R.id.whatsNew_rv);

        DateAdapter adapter = new DateAdapter(this,modals);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        date_rv.setLayoutManager(layoutManager);
        date_rv.setAdapter(adapter);

        NewGroup newsAdapter = new NewGroup(this,newsModals);
        LinearLayoutManager newslayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        whatsnew_rv.setLayoutManager(newslayoutManager);
        whatsnew_rv.setAdapter(newsAdapter);


        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BlogActivity.this,MainActivity.class);
            }
        });
    }
}
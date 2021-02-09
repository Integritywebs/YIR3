package com.tiw.yir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.tiw.yir.R;
import com.tiw.yir.adapter.AnnouncementAdapter;
import com.tiw.yir.fragment.ElectedStudentsFragment;
import com.tiw.yir.helper.Common;
import com.tiw.yir.model.AnnouncementModals;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnnouncementActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    CircleImageView img1;
    List<AnnouncementModals> announcementModals = new ArrayList<>();
    AnnouncementAdapter adapter;
    Activity context;
    ImageView back_btn;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Common.isInternetAvailable(this)){
            setContentView(R.layout.activity_announcement);
            inIt();

        }else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }

    }

    private void inIt() {
        recyclerView = findViewById(R.id.recyclerView);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AnnouncementActivity.this,MainActivity.class);
            }
        });

        announcementModals.add(new AnnouncementModals(R.drawable.elected_student_0,"Elected Student Leader"));
        announcementModals.add(new AnnouncementModals(R.drawable.scholarship_awards_0,"Scholarship Awards"));
        announcementModals.add(new AnnouncementModals(R.drawable.monthly_awards_0,"Monthly Scholarship Awards"));
        announcementModals.add(new AnnouncementModals(R.drawable.total_application_0,"Total Applications"));


        AnnouncementAdapter adapter = new AnnouncementAdapter(announcementModals, context,this.getSupportFragmentManager());
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.announcement_container, new ElectedStudentsFragment()).commit();


    }


}
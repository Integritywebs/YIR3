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

import com.google.android.material.tabs.TabLayout;
import com.tiw.yir.R;
import com.tiw.yir.adapter.EventAdapter;
import com.tiw.yir.model.EventModal;

import java.util.ArrayList;
import java.util.List;


public class EventsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<EventModal> modals = new ArrayList<>();
    TabLayout tabLayout;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_events);
        EventModal modal = new EventModal();
        modal.setDate("20 Aug 2020");
        for (int i = 0; i < 2; i++) {
            modals.add(modal);
        }


        recyclerView = findViewById(R.id.recyclerView);
        tabLayout = findViewById(R.id.tabLayout);

        for(int i=0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(0, 0, 50, 0);
            tab.requestLayout();
        }



        EventAdapter adapter = new EventAdapter(this,modals);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(EventsActivity.this,MainActivity.class);
            }
        });
    }
}
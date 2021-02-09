package com.tiw.yir.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tiw.yir.R;
import com.tiw.yir.helper.Common;


public class AboutUsActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.activity_about_us);
            getSupportActionBar().show();

        }else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }
    }
}

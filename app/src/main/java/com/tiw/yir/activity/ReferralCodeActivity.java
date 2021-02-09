package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import com.tiw.yir.R;
public class ReferralCodeActivity extends AppCompatActivity {

    EditText et_Name,et_mobile,et_email,et_memberID;
    CheckBox checkBox;
    LinearLayout submit_btn;
    ImageView back_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_referral_code);

        et_Name = findViewById(R.id.editText_fullName);
        et_mobile = findViewById(R.id.editText_MobileNo);
        et_email = findViewById(R.id.editText_emailID);
        et_memberID = findViewById(R.id.editText_memberID);
        submit_btn = findViewById(R.id.submit_layout);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ReferralCodeActivity.this,MainActivity.class);
            }
        });
    }
}
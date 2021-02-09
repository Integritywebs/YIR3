package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tiw.yir.R;

public class ProfileActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText etName,etMobile,etEmail;
    private TextView btnSave;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        init();
    }

    private void init() {
        etName=findViewById(R.id.et_name);
        etMobile=findViewById(R.id.et_mobile_no);
        etEmail=findViewById(R.id.et_email);
        btnSave=findViewById(R.id.tv_save);

        btnSave.setOnClickListener(this::onClick);

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProfileActivity2.this,ProfileActivity.class);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        if (vId == R.id.tv_save){
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tiw.yir.R;
import com.tiw.yir.activity.ScholershipFormActivity;
import com.tiw.yir.helper.Common;
import com.tiw.yir.model.SelectedStudentModal;

public class ScholerShipActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cardviewmembership1,cardviewScholership2;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_scholer_ship);
        inIt();
    }

    private void inIt() {
        cardviewmembership1=findViewById(R.id.cardviewmembership1);
        cardviewScholership2=findViewById(R.id.cardviewScholership2);

        cardviewmembership1.setOnClickListener(this::onClick);
        cardviewScholership2.setOnClickListener(this::onClick);
        back_btn = findViewById(R.id.ivBack);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScholerShipActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {


        int vId=view.getId();

        if (vId==R.id.cardviewmembership1){
            Intent intent = new Intent(this, ScholershipFormActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewScholership2){
            Intent intent = new Intent(this, ScholershipFormActivity.class);
            startActivity(intent);
        }
    }
}
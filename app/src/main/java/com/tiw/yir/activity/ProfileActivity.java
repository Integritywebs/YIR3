package com.tiw.yir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.tiw.yir.R;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.logins.LoginActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView imageproductview;
    private CardView cardViewProfile,cardViewAbout,cardViewHelp,cardViewLogout;
    private ImageView ivedit;
    private Button btnlogout;
    ImageView back_btn;
    private SaveSharedPreference preference;
    private TextView tvusername,tvemail,tvMobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Common.isInternetAvailable(this)){
            setContentView(R.layout.activity_profile);
            inIt();
            preference = new SaveSharedPreference(this);
            setListener();

        }else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }
    }

    private void setListener() {
        cardViewLogout.setOnClickListener(this::onClick);
    }

    /**
     * In this function we initialize the variables.
     */
    private void inIt() {
        cardViewProfile=findViewById(R.id.cardViewProfile);
        cardViewAbout=findViewById(R.id.cardViewAbout);
        cardViewHelp=findViewById(R.id.cardViewHelp);
        cardViewLogout=findViewById(R.id.cardViewLogout);
        tvusername=findViewById(R.id.userName);
        tvemail=findViewById(R.id.uemail);
        tvMobile=findViewById(R.id.uMobile);
        cardViewProfile.setOnClickListener(this::onClick);


        back_btn = findViewById(R.id.ivBack);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        saveData();
    }

    private void saveData() {
        if (preference!=null) {


            tvMobile.setText(preference.getMobileNumber(SaveSharedPreference.MOBILE_NUMBER));
            tvusername.setText(preference.getUSERNAME(SaveSharedPreference.USERNAME));
            tvemail.setText(preference.getEMAIL(SaveSharedPreference.EMAIL));
        }
    }

    /**
     * @param v
     * Here we set the onClick listener
     */
    @Override
    public void onClick(View v) {
        int vId=v.getId();
        if (vId == R.id.cardViewLogout) {

//            SharedPreferences.Editor editor = prf.edit();
//            editor.clear();
//            editor.apply();
            SaveSharedPreference.setLoggedIn(getApplicationContext(), false);

            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();


        }
        else if (vId == R.id.cardViewProfile){
            Intent intent = new Intent(getApplicationContext(),ProfileActivity2.class);
            startActivity(intent);
        }

    }
}

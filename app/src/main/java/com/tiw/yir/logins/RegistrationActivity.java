package com.tiw.yir.logins;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tiw.yir.R;
import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.controller.PreferenceManager;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.Loginpojo;
import com.tiw.yir.model.RegistrationResponse;
import com.tiw.yir.network.ApiClient;
import com.tiw.yir.untils.FuncsVars;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import javax.crypto.SecretKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName;

     EditText etPhone;
    private EditText etEmail;
    private EditText etpassword;
    Button btnSignUp, verifyotp;
    private TextView txSignin;
    private CheckBox checkcontion;
    ProgressDialog progressDialog;
    SaveSharedPreference preference;

    private String username, email, phone, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etPhone =(EditText) findViewById(R.id.etPhone);
      verifyotp = findViewById(R.id.verifyotp);


        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.activity_registration);
            preference = new SaveSharedPreference(this);
            inIt();


        } else {
            setContentView(R.layout.error_layout);
            Common.InternetError(this);

        }

    }



    private void inIt() {

        etUserName = findViewById(R.id.etUserName);
        etPhone = findViewById(R.id.etPhone);
        verifyotp = findViewById(R.id.verifyotp);
        etEmail = findViewById(R.id.etEmail);
        etpassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        txSignin = findViewById(R.id.txSignin);
        checkcontion = findViewById(R.id.checkcontion);
        inItListener();
    }
    
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");

            }
        }
    };


    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }


    private void inItListener() {

        btnSignUp.setOnClickListener(this::onClick);
        txSignin.setOnClickListener(this::onClick);
        verifyotp.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();

        if (vId == R.id.btnSignUp) {
            validateregistration();
        } else if (vId == R.id.txSignin) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else if(vId == R.id.verifyotp){
            if( etPhone.getText().toString().trim().isEmpty())
            {
                etPhone.setError("Enter Phone No");
            }else{
                Intent i = new Intent(RegistrationActivity.this, OtpVerificationActivity.class);
                i.putExtra("phonenumber", etPhone.getText().toString().trim());
                startActivity(i);
                finish();
            }
        }
    }

    private void validateregistration() {
        username = etUserName.getText().toString().trim();
        preference.setUSERNAME(SaveSharedPreference.USERNAME, username);
        Log.d(this.getClass().getName(), "onResponse: " + preference.getAccessToken(SaveSharedPreference.USERNAME));
        email = etEmail.getText().toString().trim();
        preference.setEMAIL(SaveSharedPreference.EMAIL, email);
        Log.d(this.getClass().getName(), "onResponse: " + preference.getAccessToken(SaveSharedPreference.EMAIL));
        phone = etPhone.getText().toString().trim();
        preference.setMobileNumber(SaveSharedPreference.MOBILE_NUMBER, phone);
        Log.d(this.getClass().getName(), "onResponse: " + preference.getAccessToken(SaveSharedPreference.MOBILE_NUMBER));
        password = etpassword.getText().toString().trim();

        submit_task(username, email, phone, password);

        if (username.isEmpty()) {
            etUserName.setError("Enter user name");
        } else if (email.isEmpty()) {
            etEmail.setError("Enter you email");
        } else if (Common.isEmail(email)) {
            etEmail.setError("Enter vaild email");
        } else if (phone.isEmpty()) {
            etPhone.setError("Enter phone Number");
        } else if (password.isEmpty()) {
            etpassword.setError("Enter Your Date of birth");
        } else if (!checkcontion.isChecked()) {
            Toast.makeText(getApplicationContext(), "Please check Your Tream and Conditions", Toast.LENGTH_LONG).show();
        } else {

           /* Intent intent=new Intent(RegistrationActivity.this,ChoicegroupActivity.class);
            startActivity(intent);*/
        }

    }


    private void submit_task(String username, String email, String phone, String password) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        String user_role = "0";
        MyApiEndpointInterface apiService = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<RegistrationResponse> call = apiService.registration(user_role, username, email, phone, password);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {

                try {
                    RegistrationResponse electionDataResponse = response.body();
                    SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
                    preference.setAccessToken(SaveSharedPreference.ACCESS_TOKEN, electionDataResponse.getData().getSt());


                    startActivity(intent);
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Common.dismissProgressDialog();
                Toast.makeText(RegistrationActivity.this, "ddajkk", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void registerToGroup() {
        // String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);


    }


}
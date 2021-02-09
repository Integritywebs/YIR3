package com.tiw.yir.logins;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.R;
import com.tiw.yir.controller.PreferenceManager;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.Loginpojo;
import com.tiw.yir.network.ApiClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etmobilenumber;
    private EditText etpassword;
Button get_otp;
    private Button btnLogin;
    private TextView txSignup;
    private String mobile,password;
    PreferenceManager preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.activity_login);
            inIt();
            preference = new PreferenceManager(this);

        } else {
            setContentView(R.layout.error_layout);
        }

    }

    private void inIt() {
        etmobilenumber = findViewById(R.id.etmobilenumber);
        etpassword = findViewById(R.id.etpassword);
        txSignup = findViewById(R.id.txSignup);
        btnLogin = findViewById(R.id.btnLogin);
        get_otp = findViewById(R.id.get_otp);
        inItListener();

    }

    private void inItListener() {
        btnLogin.setOnClickListener(this::onClick);
        txSignup.setOnClickListener(this::onClick);
        get_otp.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {

        int vId = view.getId();
        if (vId == R.id.btnLogin) {

            validateLogin();
        } else if (vId == R.id.txSignup) {

            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        } else if (vId == R.id.get_otp) {
            if (etmobilenumber.getText().toString().trim().isEmpty()) {
                etmobilenumber.setError("Enter Phone No");
            } else {
                Intent i = new Intent(LoginActivity.this, OtpVerificationActivity.class);
                i.putExtra("phonenumber", etmobilenumber.getText().toString().trim());
                startActivity(i);
                finish();
            }
        }
    }

    private void validateLogin() {

        mobile = etmobilenumber.getText().toString().trim();
        password = etpassword.getText().toString().trim();


        if (mobile.isEmpty()) {
            etmobilenumber.setError("Enter your Mobile Number");
        }
        else if (password.isEmpty()){
            etpassword.setError("Enter your Password ");

        }

            else
        {

            Common.showProgressDialog(this);
            submit_task(mobile,password);

        }

    }

    private void submit_task(String mobile, String password) {


        MyApiEndpointInterface service = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<Loginpojo> userCall = service.login(mobile.toString().trim(),password.toString().trim());
        userCall.enqueue(new Callback<Loginpojo>() {
            @Override
            public void onResponse(@NotNull Call<Loginpojo> call, @NotNull Response<Loginpojo> response) {

//                if (response.isSuccessful()){
                    try {
                        Loginpojo loginpojo = response.body();
                        Log.d("jguy", "onResponse");
                        assert loginpojo != null;
                        Loginpojo.Data loginpojon = loginpojo.getData();

                        SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
                        // SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
                       preference.setAccessToken(SaveSharedPreference.ACCESS_TOKEN,loginpojo.getData().getSt());
                        Log.d(this.getClass().getName(), "onResponse: "+preference.getAccessToken(PreferenceManager.ACCESS_TOKEN));
//                    editor.putString("user_id", String.valueOf(loginpojon.getId()));
//                    editor.putString("email", loginpojon.getEmail());
//                    editor.putString("mobile", loginpojon.getMobile());
//                    editor.putString("user_status", loginpojon.getSt());
//
//
//                    editor.apply();
                        //emptyInputEditText();
                        startActivity(intent);

                        Common.dismissProgressDialog();

                    } catch (Exception e) {
                        System.out.print("NullPointerException Caught");
                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Bad email or password", Toast.LENGTH_SHORT).show();
//                    Common.dismissProgressDialog();
//                }

            }

            @Override
            public void onFailure(@NotNull Call<Loginpojo> call, @NotNull Throwable t) {
                Common.dismissProgressDialog();
                Log.d("fds","Error");
                Common.toastMessage(LoginActivity.this);
                Log.d("onFailure", t.toString());
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PhoneActivityTAG", "Phone number: " + "");
                } else {
                    Toast.makeText(this, "Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}

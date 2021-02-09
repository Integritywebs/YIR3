package com.tiw.yir.logins;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tiw.yir.R;
import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.helper.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.acl.Group;
import java.util.Random;

public class OtpVerificationActivity extends AppCompatActivity {
    int randonnumber;
    String phonenumber;
    Button verifyotp,getVerifyotp;
    EditText otptext;
    String otp_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        verifyotp = (Button) findViewById(R.id.verifyotp);
        getVerifyotp = (Button) findViewById(R.id.get_otp_no);
        otptext = (EditText) findViewById(R.id.otptext);
        final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Intent intent = getIntent();
        phonenumber = intent.getStringExtra("phonenumber");
        Toast.makeText(OtpVerificationActivity.this, "" + phonenumber, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void initialsendotp() {
        try {
            // Construct data
            //Your user name
            String username = "YOUNGIND";
            //Your authentication key
            String authkey = "3912b764eaXX";
            //Multiple mobiles numbers separated by comma (max 200)
            String mobiles = "+91" + phonenumber;
            //Sender ID,While using route4 sender id should be 6 characters long.
            String senderId = "YIROTP";
            //Generating random number
            Random random = new Random();
            randonnumber = random.nextInt(99999);
            //Your message to send, Add URL encoding here.
            String sms = "Your OTP is " + randonnumber;

            //define route
            String accusage = "6";
            //Prepare Url
            URLConnection myURLConnection = null;
            URL myURL = null;
            BufferedReader reader = null;

            //encoding message
            String encoded_message = URLEncoder.encode(sms, java.nio.charset.StandardCharsets.UTF_8.toString());


            //Send SMS API
            String mainUrl = "https://foxxsms.net/sms//submitsms.jsp?";

            //Prepare parameter string

            //final string
            String sbPostData = mainUrl + "user=" + "YOUNGIND" +
                    "&key=" + "3912b764eaXX" +
                    "&mobile=" + mobiles +
                    "&message=" + encoded_message +
                    "&senderid=" + "YIROTP" +
                    "&accusage=" + "1";
            mainUrl = sbPostData;
            try {
                //prepare connection
                myURL = new URL(mainUrl);
                myURLConnection = myURL.openConnection();
                myURLConnection.connect();
                reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                //reading response
                String response;
                while ((response = reader.readLine()) != null)
                    //print response
                    System.out.println(reader);

                //finally close connection
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void GetOTPNO(View view) {
        initialsendotp();
        Toast.makeText(OtpVerificationActivity.this, "OTP SENT< Please Wait you may recieved in a movement", Toast.LENGTH_LONG).show();
        getVerifyotp.setVisibility(View.GONE);
    }

    public void verifyOTP(View view) {
        Toast.makeText(OtpVerificationActivity.this, "OTP Confirmed", Toast.LENGTH_LONG).show();
        otp_text = otptext.getText().toString().trim();
        if (otp_text.equals(String.valueOf(randonnumber))) {
            Toast.makeText(OtpVerificationActivity.this, "user login in successfully", Toast.LENGTH_LONG).show();
            finish();
            Intent mainactivity = new Intent(OtpVerificationActivity.this, ChoicegroupActivity.class);
            startActivity(mainactivity);
        } else {
            Toast.makeText(OtpVerificationActivity.this, "Invalid OTP, Please Try Again", Toast.LENGTH_LONG).show();
        }
    }
}
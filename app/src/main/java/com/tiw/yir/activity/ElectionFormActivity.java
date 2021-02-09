package com.tiw.yir.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tiw.yir.Others.Validation;
import com.tiw.yir.R;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.ElectionDataResponse;

import java.util.Calendar;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ElectionFormActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener,View.OnClickListener {
    ImageView backBtn, profileBtn;
    EditText etName, etMobile, etEmail, etDOB, etDescription, etMenifesto;
    CheckBox checkBox;
    Button submitBtn;
    ImageView back_btn;
    Spinner spinner;
    SaveSharedPreference preference;
    private int mYear, mMonth, mDay;
    ProgressDialog progressDialog;

    String[] chooseGroup = {"Choose group", "Group 1", "Group 2","Group 3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.fragment_election_form);
            inIt();
            preference = new SaveSharedPreference(this);
        } else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }




    }

    private void inIt() {
        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile_no);
        etEmail = findViewById(R.id.etemail);
        etDOB = findViewById(R.id.et_DOB);
        etDescription = findViewById(R.id.et_description);
        etMenifesto = findViewById(R.id.et_manifesto);
        checkBox = findViewById(R.id.checkbox);
        submitBtn = findViewById(R.id.btnsubmit);

        spinner = findViewById(R.id.choose_group);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, chooseGroup);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        submitBtn.setOnClickListener(this);


        submitBtn.setOnClickListener(view -> {
            if (etName.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter your name.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidName(etName.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid name.", Toast.LENGTH_SHORT).show();
            } else if (etEmail.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter email address.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidEmail(etEmail.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid email address.", Toast.LENGTH_SHORT).show();
            } else if (etMobile.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter mobile number.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidPhoneNumber(etMobile.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid mobile number.", Toast.LENGTH_SHORT).show();
            } else if (etDOB.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter your date of birth.", Toast.LENGTH_SHORT).show();
            } else if (!checkBox.isChecked()) {
                Toast.makeText(getApplicationContext(), "Please check term & condition.", Toast.LENGTH_SHORT).show();
            } else {
                String Name = etName.getText().toString().trim();
                String Email = etEmail.getText().toString().trim();
                String Mobile = etMobile.getText().toString().trim();
                String DOB = etDOB.getText().toString().trim();
                String SpinnerId = spinner.getSelectedItem().toString().trim();
                String Description = etDescription.getText().toString().trim();
                String Manifesto = etMenifesto.getText().toString().trim();

                if (!Validation.isNetworkAvailable(getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                } else {
                    submit_Task(Name, Email, Mobile, DOB, SpinnerId,Description,Manifesto);
                }
            }
        });
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ElectionFormActivity.this,MainActivity.class);
            }
        });


    }

    private void submit_Task(String name, String email, String mobile, String dob, String spinnerId, String description, String manifesto) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        String token = preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);
        MyApiEndpointInterface services = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<ElectionDataResponse> call = services.apply_for_vote(token,name,email,mobile,dob,spinnerId,description,manifesto);
        call.enqueue(new Callback<ElectionDataResponse>() {
            @Override
            public void onResponse(Call<ElectionDataResponse> call, Response<ElectionDataResponse> response) {
//                if (response.isSuccessful()) {
                    try {
                        ElectionDataResponse electionDataResponse = response.body();

                        if (electionDataResponse.getMessage().equalsIgnoreCase("Success !! Customer is created successfully")) {
                            progressDialog.dismiss();

                            startActivity(new Intent(getApplicationContext(),ElectionPollingActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), electionDataResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                } else {
                    /*This part handles if the data already exists and response from the server is 404*/
                    if (response.code() == 404) {
                        Toast.makeText(getApplicationContext(), "You have already voted, Voting can be done only once", Toast.LENGTH_SHORT).show();
                        Intent scholarIntent = new Intent(getApplicationContext(), ElectionPollingActivity.class);
                        startActivity(scholarIntent);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            finish();
                        }
//                    }

                }
            }

            @Override
            public void onFailure(Call<ElectionDataResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        int vId = view.getId();

        if (vId == R.id.etdateofbirht) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            etDOB.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }  else {
            Toast.makeText(this, "You are offline", Toast.LENGTH_SHORT).show();
        }


    }
}
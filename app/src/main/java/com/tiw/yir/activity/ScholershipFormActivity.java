package com.tiw.yir.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tiw.yir.Others.AppPreferance;
import com.tiw.yir.Others.Validation;
import com.tiw.yir.R;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.ApplyForScholarshipResponse;
import com.tiw.yir.model.Loginpojo;
import com.tiw.yir.model.Loginpojo.Data;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScholershipFormActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinnergender, spinnerid;
    EditText etname, etmobilenumber, etemail, etdateofbirht, etvarificationid;
    Button btnsubmit;
    TextView addPhoto;
    ImageView back_btn;
    private int mYear, mMonth, mDay;
    ArrayList<String> listAllspinnergender = new ArrayList<String>();
    ArrayList<String> listAllspinnerid = new ArrayList<String>();
    SaveSharedPreference preference;


    ProgressDialog progressDialog;
    CheckBox checkTerm;
    private String Document_img1 = "";
    public static final String KEY_User_IMAGE1 = "img1";
    Uri cameraUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Common.isInternetAvailable(this)) {
            setContentView(R.layout.activity_scholership_form);
            inIt();
            preference = new SaveSharedPreference(this);
        } else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }
    }

    private void inIt() {

        etname = findViewById(R.id.etname);
        etmobilenumber = findViewById(R.id.etmobilenumber);
        etemail = findViewById(R.id.etemail);
        etdateofbirht = findViewById(R.id.etdateofbirht);
        etvarificationid = findViewById(R.id.etvarificationid);
        btnsubmit = findViewById(R.id.btnsubmit);
        checkTerm = findViewById(R.id.checkTerm);
        addPhoto = findViewById(R.id.add_photo);

        spinnergender = (Spinner) findViewById(R.id.spinnergender);
        spinnerid = (Spinner) findViewById(R.id.spinnerid);


        etdateofbirht.setOnClickListener(this);
        addPhoto.setOnClickListener(this);
        setGenderData();
        setSpinnerIdData();


        btnsubmit.setOnClickListener(view -> {
            if (etname.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter your name.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidName(etname.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid name.", Toast.LENGTH_SHORT).show();
            } else if (etemail.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter email address.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidEmail(etemail.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid email address.", Toast.LENGTH_SHORT).show();
            } else if (etmobilenumber.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter mobile number.", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidPhoneNumber(etmobilenumber.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Please enter valid mobile number.", Toast.LENGTH_SHORT).show();
            } else if (etdateofbirht.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter your date of birth.", Toast.LENGTH_SHORT).show();
            } else if (!checkTerm.isChecked()) {
                Toast.makeText(getApplicationContext(), "Please check term & condition.", Toast.LENGTH_SHORT).show();
            } else {
                String Name = etname.getText().toString().trim();
                String Email = etemail.getText().toString().trim();
                String Mobile = etmobilenumber.getText().toString().trim();
                String DOB = etdateofbirht.getText().toString().trim();
                String VerificationId = etvarificationid.getText().toString().trim();
                String photo = addPhoto.getText().toString().trim();
                String Gender = spinnergender.getSelectedItem().toString().trim();
                String SpinnerId = spinnerid.getSelectedItem().toString().trim();

                if (!Validation.isNetworkAvailable(getApplicationContext())) {
                    Toast.makeText(getApplicationContext(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                } else {
                    submit_Task(Name, Email, Mobile, DOB,photo, VerificationId, Gender, SpinnerId);
                }
            }
        });


        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ScholershipFormActivity.this,ScholerShipActivity.class);
            }
        });
    }

    private void selectImage() {

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ScholershipFormActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, (dialog, item) -> {
            if (options[item].equals("Take Photo")) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                String fileName = "IMAGE_" + System.currentTimeMillis() + ".jpg";



            } else if (options[item].equals("Choose from Gallery")) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 2);
            } else if (options[item].equals("Cancel")) {
                dialog.dismiss();
            }
        });
        builder.show();


    }

    private void submit_Task(String name, String email, String mobile, String dob, String photo,String verificationId, String gender, String spinnerId) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        String token=preference.getAccessToken(SaveSharedPreference.ACCESS_TOKEN);
        Log.d(this.getClass().getName(), "submit_Task: "+token);
        String scholarship_id = AppPreferance.getSChOLARSHIP_ID(getApplicationContext(), AppPreferance.SChOLARSHIP_ID);
       // String photo = "nknkf";
        MyApiEndpointInterface apiService = APIService.getClient().create(MyApiEndpointInterface.class);
        Call<ApplyForScholarshipResponse> call = apiService.apply_for_scholarship(token, scholarship_id, name, email, mobile, dob, gender, photo, verificationId, gender, spinnerId);
        call.enqueue(new Callback<ApplyForScholarshipResponse>() {
            @Override
            public void onResponse(Call<ApplyForScholarshipResponse> call, Response<ApplyForScholarshipResponse> response) {
                /*Handling the server response*/
//                if (response.isSuccessful()) {
                    try {
                        ApplyForScholarshipResponse electionDataResponse = response.body();
                        //Log.d(getTag(), "onResponse: "+response.message());
                        if (electionDataResponse.getMsg().equalsIgnoreCase("You has already applied under Scholarship 1")) {
                            progressDialog.dismiss();
                            AppPreferance.setAuthorization(getApplicationContext(), (electionDataResponse.getMsg()), "9 Users are remaining to get this Scholarship.");
                            startActivity(new Intent(getApplicationContext(), ScholerShipActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), electionDataResponse.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                } else {
//                    /*This part handles if the data already exists and response from the server is 404*/
//                    if (response.code() == 404) {
//                        Toast.makeText(getApplicationContext(), "You have already voted, Voting can be done only once", Toast.LENGTH_SHORT).show();
//                        progressDialog.dismiss();
//                        Intent scholarIntent = new Intent(getApplicationContext(), ScholerShipActivity.class);
//                        startActivity(scholarIntent);
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                            finish();
//                        }
//                    }
//
//                }
            }

            @Override
            public void onFailure(Call<ApplyForScholarshipResponse> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }


    private void setGenderData() {
        spinnergenders();
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAllspinnergender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnergender.setAdapter(genderAdapter);
    }


   private void setSpinnerIdData(){
        spinnerids();
        ArrayAdapter<String> spinneridsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAllspinnerid);
        spinneridsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerid.setAdapter(spinneridsAdapter);

    }


    private void spinnerids() {

        listAllspinnerid.add("Choose Verification ID");
        listAllspinnerid.add("Adhar card");
        listAllspinnerid.add("Voter Id");
        listAllspinnerid.add("Driving Licence");
    }

    private void spinnergenders() {

        listAllspinnergender.add("Choose Gender");
        listAllspinnergender.add("Male");
        listAllspinnergender.add("Female");
        listAllspinnergender.add("Transgender");
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
                            etdateofbirht.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        } else if (vId == R.id.add_photo) {
            selectImage();
        } else {
            Toast.makeText(this, "You are offline", Toast.LENGTH_SHORT).show();
        }


    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
                    bitmap = getResizedBitmap(bitmap, 400);
                    // IDProf.setImageBitmap(bitmap);
                    BitMapToString(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        addPhoto.setText(String.valueOf(System.currentTimeMillis()) + ".jpg");
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                thumbnail = getResizedBitmap(thumbnail, 400);
                addPhoto.setText(String.valueOf(System.currentTimeMillis()) + ".jpg");
                Log.w("path of image from gallery......******************.........", picturePath + "");
                //IDProf.setImageBitmap(thumbnail);
                BitMapToString(thumbnail);
            }
        }
    }

    public String BitMapToString(Bitmap userImage1) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        userImage1.compress(Bitmap.CompressFormat.PNG, 60, baos);
        byte[] b = baos.toByteArray();
        Log.d(getClass().getName(), "BitMapToString: "+b);
        Document_img1 = Base64.encodeToString(b, Base64.DEFAULT);
        return Document_img1;
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


}
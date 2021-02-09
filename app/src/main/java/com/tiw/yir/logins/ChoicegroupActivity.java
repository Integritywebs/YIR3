package com.tiw.yir.logins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.tiw.yir.R;
import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.adapter.GroupAdapter;
import com.tiw.yir.helper.APIService;
import com.tiw.yir.helper.Common;
import com.tiw.yir.helper.MyApiEndpointInterface;
import com.tiw.yir.helper.SaveSharedPreference;
import com.tiw.yir.model.GroupModel;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChoicegroupActivity extends AppCompatActivity implements PaymentResultListener {
    private RecyclerView recyclervieworder;
    List<GroupModel> modal = new ArrayList<GroupModel>();
    SaveSharedPreference preference;
    GroupAdapter adapter;
    Button  btnjoingroup;
    String TAG = "PaymentError";
    private Context context;
    private int code;
    private String response;
    private String razorpayPaymentID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choicegroup);
        Checkout.preload(getApplicationContext());

        if (Common.isInternetAvailable(this)) {
            inIt();
            RazerPay();
        } else {
            Common.InternetError(this);
            setContentView(R.layout.error_layout);
        }
    }

    private void inIt() {

        List<GroupModel> albumList = new ArrayList<>();
        recyclervieworder =findViewById(R.id.recyclerviewchoose);
        Common.verticalRecyclerView(this, recyclervieworder);
        recyclervieworder.setAdapter(new GroupAdapter(this, albumList));
        btnData(recyclervieworder, albumList);
        return;
    }
   private void RazerPay(){
        btnjoingroup = findViewById(R.id.btnjoingroup);
        inItListener();
    }

    private void inItListener() {
       btnjoingroup.setOnClickListener(this::onClick);
    }

    private void onClick(@NotNull View view) {
        int vId = view.getId();
        if (vId == R.id.btnLogin) {
            startPayment();
        }else {}
    }
    public void startPayment() {

        /**
         * Instantiate Checkout
         */
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_live_L2DYse9ySpvPVN");
        /**
         * Set your logo here
         */
        checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Merchant Name");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "10000");//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact","9988776655");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }
    /*public void rezorpayCall() {
        final Checkout co = new Checkout();
        try {
            JSONObject options = new JSONObject();
            options.put("name", "Razorpay Corp");
            options.put("description", "Demoing Charges");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("currency", "INR");
            options.put("amount", "100");

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9876543210");
            options.put("prefill", preFill);
            co.open((Activity) context, options);

        } catch (Exception e) {
            Toast.makeText(context, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            e.printStackTrace();
        }
    }*/
    private void btnData(RecyclerView recyclervieworder, List<GroupModel> albumList) {


        GroupModel a = new GroupModel("0", "Group1(28/30 member)","2 Members are remaining to get this group full","1");
        albumList.add(a);

        a = new GroupModel("1", "Group1(29/30 member)", "2 Members are remaining to get this group full","1");
        albumList.add(a);

        a = new GroupModel("2", "Group1(30/30 member)", "Group is full","0");
        albumList.add(a);

       /* @Override
        public void onPaymentSuccess(String razorpayPaymentID) {
            this.razorpayPaymentID = razorpayPaymentID;
            Intent intent=new Intent(context,MainActivity.class);
            context.startActivity(intent);
            Toast.makeText(context, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaymentError(int code, String response) {
            this.code = code;
            this.response = response;
            try {
                Toast.makeText(context, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.e("error", "Exception in onPaymentError", e);
            }
        }*/

    }

    @Override
    public void onPaymentSuccess(String s) {
        this.razorpayPaymentID = razorpayPaymentID;
        try {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            Toast.makeText(context, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("error", "Exception in onPaymentError", e);
        }
    }

    @Override
    public void onPaymentError(int i, String s) {
        this.code = code;
        this.response = response;
        try {

            Toast.makeText(context, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("error", "Exception in onPaymentError", e);
        }
    }

  /*  @Override
    public void onPaymentSuccess(String s) {
        Intent intent = new Intent(ChoicegroupActivity.this, RegistrationActivity.class);
        startActivity(intent);
        this.razorpayPaymentID = razorpayPaymentID;
        context.startActivity(intent);
        Toast.makeText(context, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        this.code = code;
        this.response = response;
        try {
            Toast.makeText(context, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("error", "Exception in onPaymentError", e);
        }
    }*/
}
//    private void inIt() {
//        List<GroupModel.Datum> albumList = new ArrayList<>();
//        recyclervieworder = findViewById(R.id.recyclerviewchoose);
//        Common.verticalRecyclerView(this, recyclervieworder);
////        recyclervieworder.setAdapter(new GroupAdapter(this, albumList));
////        btnData(recyclervieworder, albumList);
////
////        return;
//
//
//        btnData(recyclervieworder, albumList);
//
//        return;
//    }
//

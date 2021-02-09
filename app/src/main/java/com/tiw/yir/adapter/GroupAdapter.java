package com.tiw.yir.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.tiw.yir.R;
import com.tiw.yir.activity.MainActivity;
import com.tiw.yir.logins.ChoicegroupActivity;
import com.tiw.yir.logins.LoginActivity;
import com.tiw.yir.model.GroupModel;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupAdapterViewHolder>  {

    private Context context;
    private List<GroupModel> albumList;
 /*   private int code;
    private String response;
    private String razorpayPaymentID;*/

    public GroupAdapter(Context context, List<GroupModel> albumList) {
        this.context = context;
        this.albumList = albumList;
    }
    @NonNull
    @Override
    public GroupAdapter.GroupAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_group, parent, false);
        return new GroupAdapter.GroupAdapterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.GroupAdapterViewHolder holder, int position) {

        holder.tvgroupname.setText(albumList.get(position).getGroupName());
        holder.tvgroupdetails.setText(albumList.get(position).getGroupDetails());
        if (albumList.get(position).getStaus() == "0") {
            holder.btnjoingroup.setVisibility(View.INVISIBLE);
        } else {
            holder.btnjoingroup.setVisibility(View.VISIBLE);
            holder.btnjoingroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String convertedAmount = String.valueOf(Integer.parseInt("100") * 100);
                    //rezorpayCall();

                }
            });

        }
    }

/*    public void rezorpayCall() {
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
    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class GroupAdapterViewHolder extends RecyclerView.ViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tvgroupname)
        TextView tvgroupname;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tvgroupdetails)
        TextView tvgroupdetails;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.btnjoingroup)
        Button btnjoingroup;

        public GroupAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            Checkout.preload(context);
        }
    }



}
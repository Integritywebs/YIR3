package com.tiw.yir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tiw.yir.R;
import com.tiw.yir.activity.AnnouncementActivity;
import com.tiw.yir.activity.EMagazinesActivity;
import com.tiw.yir.activity.ElectionPollingActivity;
import com.tiw.yir.activity.EventsActivity;
import com.tiw.yir.activity.FacebookFeedActvity;
import com.tiw.yir.activity.FeedBackActivity;
import com.tiw.yir.activity.InstagramFeed;
import com.tiw.yir.activity.InteractionActivity;
import com.tiw.yir.activity.LiveNewsActivity;
import com.tiw.yir.activity.ProductActivity;
import com.tiw.yir.activity.PropagandaActivity;
import com.tiw.yir.activity.ReferralCodeActivity;
import com.tiw.yir.activity.ScholerShipActivity;
import com.tiw.yir.activity.YoutubeFeedsActivity;
import com.tiw.yir.helper.Common;


public class HomeFragment extends Fragment implements View.OnClickListener{

//    private RecyclerView recyclerviewSocialmedia,recyclerviewgeneral,recyclerviewarroundyou,recyclerviewmenbership;
    private View view;
    private CardView cardviewScholer,cardviewfacebook,cardviewinstagram,cardviewyoutube,cardannounsment,cardviewpelection,cardviewelection,cardviewFeedback,cardviewinteration,cardviewartical,cardviewLiveNews,cardviewEvent,cardviewproduct,cardviewreferalcode,cardviewmembership,cardviewemagzin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (Common.isInternetAvailable(getContext())) {
            view=inflater.inflate(R.layout.fragment_home, container, false);
            inIt();
        } else {
            Common.InternetError(getContext());
            view=inflater.inflate(R.layout.error_layout, container, false);
        }
        return view;
    }

    private void inIt() {


        cardviewScholer=view.findViewById(R.id.cardviewScholer);
        cardviewfacebook=view.findViewById(R.id.cardviewfacebook);
        cardviewinstagram=view.findViewById(R.id.cardviewinstagram);
        cardviewyoutube=view.findViewById(R.id.cardviewyoutube);
        cardannounsment=view.findViewById(R.id.cardannounsment);
        cardviewpelection=view.findViewById(R.id.cardviewpelection);
        cardviewelection=view.findViewById(R.id.cardviewelection);
        cardviewFeedback=view.findViewById(R.id.cardviewFeedback);
        cardviewinteration=view.findViewById(R.id.cardviewinteration);
        cardviewartical=view.findViewById(R.id.cardviewartical);
        cardviewLiveNews=view.findViewById(R.id.cardviewLiveNews);
        cardviewEvent=view.findViewById(R.id.cardviewEvent);
        cardviewproduct=view.findViewById(R.id.cardviewproduct);
        cardviewreferalcode=view.findViewById(R.id.cardviewreferalcode);
        cardviewmembership=view.findViewById(R.id.cardviewmembership);
        cardviewemagzin=view.findViewById(R.id.cardviewemagzin);


        cardviewScholer.setOnClickListener(this::onClick);
        cardviewfacebook.setOnClickListener(this::onClick);
        cardviewinstagram.setOnClickListener(this::onClick);
        cardviewyoutube.setOnClickListener(this::onClick);
        cardannounsment.setOnClickListener(this::onClick);
        cardviewpelection.setOnClickListener(this::onClick);
        cardviewelection.setOnClickListener(this::onClick);
        cardviewFeedback.setOnClickListener(this::onClick);
        cardviewinteration.setOnClickListener(this::onClick);
        cardviewartical.setOnClickListener(this::onClick);
        cardviewLiveNews.setOnClickListener(this::onClick);
        cardviewEvent.setOnClickListener(this::onClick);
        cardviewproduct.setOnClickListener(this::onClick);
        cardviewreferalcode.setOnClickListener(this::onClick);
        cardviewmembership.setOnClickListener(this::onClick);
        cardviewemagzin.setOnClickListener(this::onClick);


//      .
    }

    @Override
    public void onClick(View view) {
        int vId=view.getId();

        if (vId==R.id.cardviewScholer){
            Intent intent =new Intent(getContext(), ScholerShipActivity.class);
            startActivity(intent);

        }else if (vId==R.id.cardviewfacebook){
            Intent intent =new Intent(getContext(), FacebookFeedActvity.class);
            startActivity(intent);

        }else if (vId==R.id.cardviewinstagram){

            Intent intent =new Intent(getContext(), InstagramFeed.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewyoutube){
            Intent intent =new Intent(getContext(), YoutubeFeedsActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardannounsment){
            Intent intent =new Intent(getContext(), AnnouncementActivity.class);
            startActivity(intent);
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnnouncementFragment()).commit();
        }else if (vId==R.id.cardviewpelection){
            Intent intent =new Intent(getContext(), PropagandaActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewelection){
            Intent intent =new Intent(getContext(), ElectionPollingActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewFeedback){

            Intent intent =new Intent(getContext(), FeedBackActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewinteration){

            Intent intent =new Intent(getContext(), InteractionActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewartical){

            Toast.makeText(getActivity(),"Coming soon",Toast.LENGTH_LONG).show();
//            Intent intent =new Intent(getContext(),.class);
//            startActivity(intent);
        }else if (vId==R.id.cardviewLiveNews){

            Intent intent =new Intent(getContext(), LiveNewsActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewEvent){

            Intent intent =new Intent(getContext(), EventsActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewproduct){
            Intent intent =new Intent(getContext(), ProductActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewreferalcode){
            Intent intent =new Intent(getContext(), ReferralCodeActivity.class);
            startActivity(intent);
        }else if (vId==R.id.cardviewmembership){
//            Intent intent =new Intent(getContext(), Me.class);
//            startActivity(intent);
        }else if (vId==R.id.cardviewemagzin){
            Intent intent =new Intent(getContext(), EMagazinesActivity.class);
            startActivity(intent);

        }

    }
}
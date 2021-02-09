package com.tiw.yir.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.RecentFeedAdapter;
import com.tiw.yir.adapter.RelatedVideoAdapter;
import com.tiw.yir.model.RecentFeedModals;
import com.tiw.yir.model.RelatedFeedModals;

import java.util.ArrayList;
import java.util.List;


public class YoutubeFeedsActivity extends AppCompatActivity {

    private WebView youtubeFeed;
    ProgressBar progressBar;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_youtube_feeds);

        youtubeFeed = findViewById(R.id.youtube_webview);
        progressBar = findViewById(R.id.progressBar);
        youtubeFeed.setWebViewClient(new WebViewClient());
        youtubeFeed.loadUrl("https://www.youtube.com/channel/UCl_zPUcSukEjnzpMsReMNuQ/featured");

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(YoutubeFeedsActivity.this,MainActivity.class);
            }
        });
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
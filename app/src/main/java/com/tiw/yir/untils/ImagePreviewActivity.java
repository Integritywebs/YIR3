package com.tiw.yir.untils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;
import com.tiw.yir.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagePreviewActivity extends AppCompatActivity {

	private static final String INTENT_IMAGE_URL = "intent_image_url";
	Context context = this;
	@BindView(R.id.imageView)
    PhotoView imageView;
	@Inject
	FuncsVars funcsVar;

	public static void start(Context context, String url) {
		Intent intent = new Intent(context, ImagePreviewActivity.class);
		intent.putExtra(INTENT_IMAGE_URL, url);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_image_preview);
//		ButterKnife.bind(this);
//		funcsVar.setImage(context, funcsVar.addIpInFrontOfUrl(getIntent()
//				.getStringExtra(INTENT_IMAGE_URL)), imageView, this::onBackPressed);
	}


}


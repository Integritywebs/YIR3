package com.tiw.yir.apis;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import com.tiw.yir.untils.CustomTypefaceSpan;
import com.tiw.yir.untils.FuncsVars;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgreessDialogCallBack<T> implements Callback<T> {

	public ProgressDialog progressDialog;
	private final Context context;
	private View loadingView;
	private View scrollingContents;
	private View offlineContents;
	private View noDataRoot;

	public ProgreessDialogCallBack(Context context) {
		this.context = context;
		try {
			progressDialog = new ProgressDialog(context);
			((Activity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
					WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
			progressDialog.setIndeterminate(true);
			String s = "Please Wait...";
			progressDialog.setMessage(getTypeFaceSpannable(context, s, FuncsVars.Fonts.PTSANS_SEMIBOLD));
			progressDialog.setCancelable(false);
			progressDialog.setCanceledOnTouchOutside(false);
			progressDialog.show();
		} catch (Exception e) {
			Log.e(TAG, "ProgreessDialogCallBack: ", e);
		}
	}

	private static final String TAG = ProgreessDialogCallBack.class.getSimpleName();
	public SpannableString getTypeFaceSpannable(Context context, String title, String font) {
		SpannableString spannable = new SpannableString(title);
		spannable.setSpan(new CustomTypefaceSpan("", Typeface
				.createFromAsset(context.getAssets(), font)), 0, title
				.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
		return spannable;
	}

	public ProgreessDialogCallBack(View loadingView, View scrollingContents, View offlineContents, View noDataRoot) {
		this.loadingView = loadingView;
		this.scrollingContents = scrollingContents;
		this.offlineContents = offlineContents;
		this.noDataRoot = noDataRoot;
		this.context = null;
		if (loadingView != null) {
			loadingView.setVisibility(View.VISIBLE);
		}
		if (scrollingContents != null) {
			scrollingContents.setVisibility(View.GONE);
		}
		if (offlineContents != null) {
			offlineContents.setVisibility(View.GONE);
		}
		if (noDataRoot != null) {
			noDataRoot.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		try {
			if (loadingView != null) {
				loadingView.setVisibility(View.GONE);
			}
			if (scrollingContents != null) {
				scrollingContents.setVisibility(View.VISIBLE);
			}
			if (offlineContents != null) {
				offlineContents.setVisibility(View.GONE);
			}
			if (noDataRoot != null) {
				noDataRoot.setVisibility(View.GONE);
			}
			if (context != null)
				((Activity) context).getWindow()
						.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
				((Activity) context).getWindow()
						.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
			}
		} catch (Exception e) {
			Log.e(TAG, "ProgreessDialogCallBack: ", e);
		}
	}

	@Override
	public void onFailure(Call<T> call, Throwable t) {
		try {
			if (loadingView != null) {
				loadingView.setVisibility(View.GONE);
			}
			if (scrollingContents != null) {
				scrollingContents.setVisibility(View.GONE);
			}
			if (offlineContents != null) {
				offlineContents.setVisibility(View.VISIBLE);
			}
			if (noDataRoot != null) {
				noDataRoot.setVisibility(View.VISIBLE);
			}
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
				if (context != null)
					((Activity) context).getWindow()
							.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
			}
		} catch (Exception e) {
			Log.e(TAG, "ProgreessDialogCallBack: ", e);
		}
	}
}

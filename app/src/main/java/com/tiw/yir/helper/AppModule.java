package com.tiw.yir.helper;

import android.preference.PreferenceManager;


import com.tiw.yir.apis.APIInterface;
import com.tiw.yir.untils.FuncsVars;
import com.tiw.yir.untils.MyApplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppModule {

    public static String API_BASE_IMAGE_URL = "http://159.89.168.196:2032";
    private static String API_BASE = API_BASE_IMAGE_URL + "/";

    private static String API_BASE_URL_SECURE = API_BASE + "secureApi/";
    private static String API_BASE_URL_INSECURE = API_BASE + "api/";

    private APIInterface secureClient;
    private APIInterface insecureClient;

    public AppModule() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("token", PreferenceManager
                                    .getDefaultSharedPreferences(MyApplication.getmContext())
                                    .getString(FuncsVars.SPF.TOKEN, ""))
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .addInterceptor(interceptor)
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build();

        secureClient = new Retrofit.Builder()
                .baseUrl(API_BASE_URL_SECURE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(APIInterface.class);
        insecureClient = new Retrofit.Builder()
                .baseUrl(API_BASE_URL_INSECURE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(APIInterface.class);
    }



}

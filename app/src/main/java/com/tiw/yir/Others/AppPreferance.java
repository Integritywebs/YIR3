package com.tiw.yir.Others;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferance {
    public static final String SHARED_PREFERENCE_NAME = "in.theintegritywebs";
    public static final String MOBILENO = "mobile_no";
    public static final String AUTHORIZATION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Ik9BPT0iLCJpYXQiOjE1OTg2MTM2OTd9.ks5B0Y4DAYAN78_3k8BEvnNNNZYvEEKdZ7dB5e2ZAWY";
    public static final String SChOLARSHIP_ID = "1";



    public static String getPhoneNo(Context context, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        return preferences.getString(MOBILENO,"");
    }
    public static void setPhoneNo(Context context, String value, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();
    }
    public static String getAuthorization(Context context, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        return preferences.getString(AUTHORIZATION,"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Ik13PT0iLCJpYXQiOjE1OTg1OTg1OTB9.c7XLEko3YD47ohwtBVrgAgUcBqJC-8Tk7IJoNE1t0J0");
    }
    public static void setAuthorization(Context context, String value, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();
    }
    public static String getSChOLARSHIP_ID(Context context, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        return preferences.getString(AUTHORIZATION,"1");
    }
    public static void setSChOLARSHIP_ID(Context context, String value, String key){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.commit();
    }

}

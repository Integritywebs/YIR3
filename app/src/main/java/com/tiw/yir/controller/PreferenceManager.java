package com.tiw.yir.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    public static  String ACCESS_TOKEN = "";

    public PreferenceManager(Context context) {
        this.context = context;
    }

    Context context;

    public String getAccessToken(String ips) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(ACCESS_TOKEN, Context.MODE_PRIVATE);
        return sharedPrefs.getString(ips, "LOGIN");
    }

    public void setAccessToken(String ips,String ip) {
        SharedPreferences.Editor editor = context.getSharedPreferences(ACCESS_TOKEN, Context.MODE_PRIVATE).edit();
        editor.putString(ips, ip);
        editor.apply();
    }
}

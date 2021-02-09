package com.tiw.yir.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SaveSharedPreference {

    private static final String LOGGED_IN_PREF = "logged_in_status";
    public static  String ACCESS_TOKEN = "";
    public static String USERNAME="";
    public static String EMAIL="";
    public static String MOBILE_NUMBER="";


    public SaveSharedPreference(Context context) {
        this.context = context;
    }

    Context context;




    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }

    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    public String getAccessToken(String ips) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(ACCESS_TOKEN, Context.MODE_PRIVATE);
        return sharedPrefs.getString(ips, "LOGIN");
    }

    public void setAccessToken(String ips,String ip) {
        SharedPreferences.Editor editor = context.getSharedPreferences(ACCESS_TOKEN, Context.MODE_PRIVATE).edit();
        editor.putString(ips, ip);
        editor.apply();
    }

    public String getUSERNAME(String ips){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USERNAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(ips,"USERNAME");
    }
    public void setUSERNAME(String ips,String ip){
        SharedPreferences.Editor editor = context.getSharedPreferences(USERNAME,Context.MODE_PRIVATE).edit();
        editor.putString(ips,ip);
        editor.apply();
    }

    public String getEMAIL(String ips){
        SharedPreferences sharedPreferences = context.getSharedPreferences(EMAIL,Context.MODE_PRIVATE);
        return sharedPreferences.getString(ips,"EMAIL");
    }
    public void setEMAIL(String ips,String ip){
        SharedPreferences.Editor editor = context.getSharedPreferences(EMAIL,Context.MODE_PRIVATE).edit();
        editor.putString(ips,ip);
        editor.apply();
    }

    public String getMobileNumber(String ips){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MOBILE_NUMBER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(ips,"MOBILE_NUMBER");
    }
    public void setMobileNumber(String ips,String ip){
        SharedPreferences.Editor editor = context.getSharedPreferences(MOBILE_NUMBER,Context.MODE_PRIVATE).edit();
        editor.putString(ips,ip);
        editor.apply();
    }




}

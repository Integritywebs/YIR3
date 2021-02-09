package com.tiw.yir.Others;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class holds the function for validation
 * @Created by Nitish
 *
 */
public class Validation {


    /*
    This functions check the valiation for valid email address of users.
     */

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    /*
    This function check the validation for valid mobile number of users
     */

    public static final boolean isValidPhoneNumber(String mobno)
    {
        Boolean isValid=false;
        if(mobno.trim().length()<10)
        {
            isValid = false;
        }
        if(mobno.trim().length()==10)
        {
            Pattern pattern;
            Matcher matcher;
            final String MOBILE_PATTERN = "^[7-9][0-9]{9}$";
            pattern = Pattern.compile(MOBILE_PATTERN);
            matcher = pattern.matcher(mobno);
            boolean isMatch = matcher.matches();
            if (isMatch) {
                isValid=true;
            } else {
                isValid=false;
            }
        }
        return isValid;
    }

    /*
    This function check the validation for the valid name

     */

    public static boolean isValidName(String firstName)
    {
        boolean isValidName=false;
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(firstName.replaceAll("\\s",""));
        boolean b = m.find();
        if (b == true)
            isValidName=false;
        else
            isValidName=true;
        return  isValidName;
    }
    /*
    This function check the validations for network check
     */

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static Context context;



}


package com.tiw.yir.Others;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utilities {
    // Declaration of Variables
    private ConnectivityManager connectivityManager;
    static Context context;
    private static Utilities singleton = null;


    /*
     *A private Constructor prevents any other
     * Class from instantiating
     */

    public Utilities() {
    }

    /* Static 'instance' method */
    public static Utilities getInstance(Context mContext){
        context = mContext;
        if (singleton == null)
            singleton = new Utilities();
        return singleton;
    }



}

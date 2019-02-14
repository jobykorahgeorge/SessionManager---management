package com.prince.sirius_fr.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {


    private static final String PREF_NAME = "IRA"; // Shared preferences file name
    private static final String KEY_IP_ADDRESS = "ip_address"; //Ip Address for Aadhaar App
    private static final String USER_NAME = "user_name";



    private SharedPreferences pref; // Shared Preferences object
    private SharedPreferences.Editor editor;
    private static SessionManager mInstance;

    private SessionManager(Context context) {
        int PRIVATE_MODE = 0;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static SessionManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (SessionManager.class) {
                if (mInstance == null)
                    mInstance = new SessionManager(context.getApplicationContext());
            }
        }
        return mInstance;
    }


    public void setUserName(String userName){
        editor.putString(USER_NAME,userName);
        editor.commit();
    }
    public void setKeyIpAddress(String ipAddress) {
        editor.putString(KEY_IP_ADDRESS, ipAddress);
        editor.commit();
    }



    public String getUserName(){
        return pref.getString(USER_NAME,null);
    }
    public String getKeyIpAddress() {
        return pref.getString(KEY_IP_ADDRESS, null);
    }

}

//WE can call the session simply by passing context.
//sample code---
//SessionManager mManager;//(globel)
//mManager = SessionManager.getInstance(this);//(in class)
//mManager.setKeyIpAddress("your IP");//(in use)

package com.educationalapp.eduapp.educationalapp;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.educationalapp.eduapp.educationalapp.Networks.APIUtils.APIService;
import com.educationalapp.eduapp.educationalapp.Networks.APIUtils.RetrofitServiceFactory;


/**
 * Created by ardhaps on 3/27/17.
 */

public class MyApplication extends Application {
    private static MyApplication sApp;
    public APIService mAPIService;
    //public SessionManager mSessionManager;

    public static MyApplication getInstance ()
    {
        if (sApp == null)
        {
            sApp = new MyApplication();
        }
        return sApp;
    }

    @Override
    public void onCreate ()
    {
        super.onCreate();

        sApp = this;
        mAPIService = RetrofitServiceFactory.createService(APIService.class);
    //    mSessionManager = new SessionManager(getApplicationContext());
    }

    public boolean isNetworkAvailable ()
    {
        ConnectivityManager lConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo lNetworkInfo = lConnectivityManager.getActiveNetworkInfo();
        return lNetworkInfo != null && lNetworkInfo.isConnected();
    }
}

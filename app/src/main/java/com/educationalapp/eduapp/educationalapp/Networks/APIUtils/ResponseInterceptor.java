package com.educationalapp.eduapp.educationalapp.Networks.APIUtils;

import android.content.Context;


import com.educationalapp.eduapp.educationalapp.MyApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


public class ResponseInterceptor implements Interceptor
{
    private MyApplication mApplication;
    private Context mContext;

    public ResponseInterceptor()
    {
        mApplication = MyApplication.getInstance();
        mContext = null;
    }

    public ResponseInterceptor(Context context)
    {
        mApplication = MyApplication.getInstance();
        mContext = context;
    }

    @Override
    public Response intercept (Chain chain) throws IOException
    {
        Response lResponse = chain.proceed(chain.request());
        if (lResponse.code() == 403) {
            // forbidden

        } else if (lResponse.code() == 404) {
            // endpoint not found

        } else if (lResponse.code() == 500) {
            // internal server error

        } else if (lResponse.code() == 502) {
            // bad gateway

        } else if (lResponse.code() == 503) {
            // service unavailable

        } else if (lResponse.code() == 504) {
            // gateway timeout

        }
        return lResponse;
    }
}

package com.educationalapp.eduapp.educationalapp.Networks;

import android.app.ProgressDialog;

import com.educationalapp.eduapp.educationalapp.Events.ErrorEvent;
import com.educationalapp.eduapp.educationalapp.MyApplication;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Response;

/**
 * Created by ardhaps on 3/27/17.
 */

public abstract class BaseHandlingResponse extends MyApplication {

    public ProgressDialog mProgressDialog;

    MyApplication app = MyApplication.getInstance();
    EventBus event = EventBus.getDefault();

    void handleResponse(Response<?> response, Object obj) {
        if (response.isSuccessful()) {
            event.post(obj);
        } else {
            event.post(new ErrorEvent(response));
        }
    }
}

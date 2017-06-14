package com.educationalapp.eduapp.educationalapp.Networks;

import android.app.ProgressDialog;
import android.content.Context;

import com.educationalapp.eduapp.educationalapp.Events.ErrorEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ardhaps on 5/15/17.
 */

public class HandlingPADTahunan extends BaseHandlingResponse {

    public void displayPADTahunan (Context mContext) {

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        Call<PADTahunan> call = app.mAPIService.displayPADTahunan();

        call.enqueue(new Callback<PADTahunan>() {
            @Override
            public void onResponse(Call<PADTahunan> call, Response<PADTahunan> response) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                PADTahunan padTahunan = new PADTahunan(
                        response.body().getSuccess(),
                        response.body().getTargetTahun(),
                        response.body().getRealTahun(),
                        response.body().getProsen());
                handleResponse(response, padTahunan);
            }

            @Override
            public void onFailure(Call<PADTahunan> call, Throwable t) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                event.post(new ErrorEvent(t));
            }
        });

    }
}

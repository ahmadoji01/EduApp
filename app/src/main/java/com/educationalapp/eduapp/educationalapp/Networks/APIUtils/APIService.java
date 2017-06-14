package com.educationalapp.eduapp.educationalapp.Networks.APIUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ardhaps on 3/27/17.
 */

public interface APIService {

    @GET("/eujikir3/pad_tahunan.php")
    Call<PADTahunan> displayPADTahunan(
    );

}

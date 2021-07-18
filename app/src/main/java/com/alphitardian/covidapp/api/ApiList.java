package com.alphitardian.covidapp.api;

import com.alphitardian.covidapp.models.IndonesiaResponse;
import com.alphitardian.covidapp.models.ProvinceResponse;
import com.alphitardian.covidapp.models.WorldResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiList {
    @GET("indonesia")
    Call<ArrayList<IndonesiaResponse>> getIndonesiaCase();

    @GET("indonesia/provinsi")
    Call<ArrayList<ProvinceResponse>> getProvinceCase();

    @GET(".")
    Call<ArrayList<WorldResponse>> getGlobalCase();
}

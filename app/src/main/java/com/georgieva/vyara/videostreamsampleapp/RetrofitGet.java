package com.georgieva.vyara.videostreamsampleapp;

import com.georgieva.vyara.videostreamsampleapp.Models.User;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Vyara on 16-Jun-16.
 */
public interface RetrofitGet {

    @GET("v2/5762c5e8100000c11f8b14dc")
    Call<User> getUserDetails();
}

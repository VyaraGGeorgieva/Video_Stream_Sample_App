package com.georgieva.vyara.videostreamsampleapp;

import com.georgieva.vyara.videostreamsampleapp.Models.User;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Vyara on 16-Jun-16.
 */
public interface RetrofitPost {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
    */
    @FormUrlEncoded
    @POST("v2/5762ccb210000095208b14e2")
    Call<User> postUserDetails(
            @Field("email")String name,
            @Field("password")String password);
}

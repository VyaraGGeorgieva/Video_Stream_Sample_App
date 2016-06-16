package com.georgieva.vyara.videostreamsampleapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vyara on 16-Jun-16.
 */
public class User {

    //variables in the JSON
    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    //getter-setter pairs
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

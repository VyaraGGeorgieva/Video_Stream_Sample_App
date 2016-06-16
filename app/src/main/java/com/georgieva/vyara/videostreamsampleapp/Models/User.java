package com.georgieva.vyara.videostreamsampleapp.Models;

/**
 * Created by Vyara on 16-Jun-16.
 */
public class User {

    //variables in the JSON
    private String password;
    private String email;

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

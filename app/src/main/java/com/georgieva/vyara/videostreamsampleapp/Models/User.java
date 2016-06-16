package com.georgieva.vyara.videostreamsampleapp.Models;

/**
 * Created by Vyara on 16-Jun-16.
 */
public class User {

    //variables in the JSON
    private String name;
    private String password;


    //getter-setter pairs
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

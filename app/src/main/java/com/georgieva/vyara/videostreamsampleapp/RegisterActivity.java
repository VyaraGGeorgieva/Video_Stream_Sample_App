package com.georgieva.vyara.videostreamsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void logIn(View view){
        i = new Intent(view.getContext(),LoginActivity.class);
        startActivity(i);
    }
}

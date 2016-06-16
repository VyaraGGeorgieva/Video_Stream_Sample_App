package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.georgieva.vyara.videostreamsampleapp.R;

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

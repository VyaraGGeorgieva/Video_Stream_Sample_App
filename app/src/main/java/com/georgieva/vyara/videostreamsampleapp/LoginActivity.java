package com.georgieva.vyara.videostreamsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register(View view){
        i = new Intent(view.getContext(), RegisterActivity.class);
        startActivity(i);
    }

    public void playMusic(View view){
        i = new Intent(view.getContext(), LivestreamVideoActivity.class);
        startActivity(i);
    }
}

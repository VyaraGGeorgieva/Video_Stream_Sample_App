package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.georgieva.vyara.videostreamsampleapp.R;

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

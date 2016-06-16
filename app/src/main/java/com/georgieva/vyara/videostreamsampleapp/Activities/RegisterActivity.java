package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.georgieva.vyara.videostreamsampleapp.Models.User;
import com.georgieva.vyara.videostreamsampleapp.R;
import com.georgieva.vyara.videostreamsampleapp.RetrofitPost;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    Intent i;
    EditText emailRegister;
    EditText passRegister;
    Button successBtn;
    Button registerBtn;
    TextView registerTV;
    String url = "http://www.mocky.io/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailRegister = (EditText) findViewById(R.id.emailRegister);
        passRegister = (EditText) findViewById(R.id.passRegister);
        successBtn = (Button) findViewById(R.id.successBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        registerTV = (TextView) findViewById(R.id.registerTV);

    }

    public void register (View view){
        postUser();
        String email =  emailRegister.getText().toString();
        String password = passRegister.getText().toString();
        Log.d("email", email);
        Log.d("password",password);

        registerBtn.setVisibility(View.INVISIBLE);
        registerTV.setVisibility(View.INVISIBLE);
        successBtn.setVisibility(View.VISIBLE);
        successBtn.setText("Successfully registered. Log in");


    }

//    public void logInBtn(View view){
//        i = new Intent(RegisterActivity.this,LoginActivity.class);
//        startActivity(i);
//    }
    private void postUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitPost service = retrofit.create(RetrofitPost.class);



        Call<User> call = service.postUserDetails("passowrd","email");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }


        });

    }


    public void logIn(View view) {
                i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }

}





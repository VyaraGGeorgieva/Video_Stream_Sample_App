package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.georgieva.vyara.videostreamsampleapp.Models.User;
import com.georgieva.vyara.videostreamsampleapp.R;
import com.georgieva.vyara.videostreamsampleapp.RetrofitGet;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {

    Intent i;
    String url = "http://www.mocky.io/";
    EditText input_email;
    EditText input_pass;
    private static int counterLogin = 0;
    private static int counterRegister = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = (EditText) findViewById(R.id.input_email);
        input_pass = (EditText) findViewById(R.id.input_pass);
    }

    public void register(View view) {
        counterRegister ++;
        i = new Intent(view.getContext(), RegisterActivity.class);
        startActivity(i);
    }



    public void playVideo() {
        i = new Intent(getApplicationContext(), LivestreamVideoActivity.class);
        startActivity(i);

    }

    public void getUser(View view) {
        counterLogin++;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitGet service = retrofit.create(RetrofitGet.class);

        Call<User> call = service.getUserDetails();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

                try {
                    if(counterLogin>1 && counterRegister>=1) {
                        if (input_email.getText().toString().equals("newuser@gmail.com")
                                && input_pass.getText().toString().equals("password")) {
                            Toast.makeText(getApplicationContext(), "You have successfully logged in",
                                    Toast
                                            .LENGTH_LONG).show();
                            playVideo();
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong credentials, try again",
                                    Toast
                                            .LENGTH_LONG).show();
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "no such user exists, register " +
                                "first",
                                Toast
                                        .LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
          }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }


        });
    }
}

package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.georgieva.vyara.videostreamsampleapp.R;
import com.georgieva.vyara.videostreamsampleapp.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class RegisterActivity extends AppCompatActivity {

    Intent i;
    EditText emailRegister;
    EditText passRegister;
    EditText confirmPassRegister;
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
        confirmPassRegister = (EditText)findViewById(R.id.confirmPassRegister);

    }

    public void register (View view){
        String email =  emailRegister.getText().toString();
        String password = passRegister.getText().toString();
        String confirmPass = confirmPassRegister.getText().toString();

        RequestParams params = new RequestParams();
        if(Utility.isNotNull(email) && Utility.isNotNull(password)&& Utility.isNotNull(confirmPass)) {
            if (password.equals(confirmPass)) {
                if (Utility.validate(email)) {

                    // Put Http parameter name with value of Name Edit View control
                    params.put("confirmPass", confirmPass);
                    // Put Http parameter username with value of Email Edit View control
                    params.put("username", email);
                    // Put Http parameter password with value of Password Edit View control
                    params.put("password", password);
                    // Invoke RESTful Web Service with Http parameters

                    postUser(params);
                    //String email =  emailRegister.getText().toString();
                    //String password = passRegister.getText().toString();
                    Log.d("email", email);
                    Log.d("password", password);

                    registerBtn.setVisibility(View.INVISIBLE);
                    registerTV.setVisibility(View.INVISIBLE);
                    successBtn.setVisibility(View.VISIBLE);
                    successBtn.setText("Successfully registered. Log in");
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "The passwords are not the same", Toast
                        .LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Please fill in all of the fields", Toast
                    .LENGTH_LONG).show();
        }

    }

//    public void logInBtn(View view){
//        i = new Intent(RegisterActivity.this,LoginActivity.class);
//        startActivity(i);
//    }
    private void postUser(final RequestParams params) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();

            }
        });

    }


    public void logIn(View view) {
                i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }

}





package com.georgieva.vyara.videostreamsampleapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.georgieva.vyara.videostreamsampleapp.R;
import com.georgieva.vyara.videostreamsampleapp.Utility;
import com.loopj.android.http.AsyncHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    Intent i;
    EditText emailRegister;
    EditText passRegister;
    EditText confirmPassRegister;
    Button successBtn;
    Button registerBtn;
    TextView registerTV;
    String url = "http://www.mocky.io/v2/5762c5e8100000c11f8b14dc";

    private static AsyncHttpClient client = new AsyncHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailRegister = (EditText) findViewById(R.id.emailRegister);
        passRegister = (EditText) findViewById(R.id.passRegister);
        successBtn = (Button) findViewById(R.id.successBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        registerTV = (TextView) findViewById(R.id.registerTV);
        confirmPassRegister = (EditText) findViewById(R.id.confirmPassRegister);

    }

    public void register(View view) {
        String email = emailRegister.getText().toString();
        String password = passRegister.getText().toString();
        String confirmPass = confirmPassRegister.getText().toString();

        if (Utility.isNotNull(email) && Utility.isNotNull(password) && Utility.isNotNull(confirmPass)) {
            if (password.equals(confirmPass)) {
                if (Utility.validate(email)) {


                    postUser();

                    if(email.equals("newuser@gmail.com")&& password.equals("password")) {
                        registerBtn.setVisibility(View.INVISIBLE);
                        registerTV.setVisibility(View.INVISIBLE);
                        successBtn.setVisibility(View.VISIBLE);
                        successBtn.setText("Successfully registered. Log in");
                    } else{
                        Toast.makeText(getApplicationContext(), "Please use the credentials you " +
                                "were provided with", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "The passwords are not the same", Toast
                        .LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please fill in all of the fields", Toast
                    .LENGTH_LONG).show();
        }

    }

    public void postUser() {

        new AsyncTask<String, String, String>() {

            @Override
            protected String doInBackground(String... params) {
                try {
                    String response = makePostRequest(url,
                            "{ email: \"newuser@gmail.com\", password: \"password\" }",
                            getApplicationContext());
                    return "Success";
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
        }.execute("");
    }



    @NonNull
    public static String makePostRequest(String stringUrl, String payload,
                                         Context context) throws IOException {
        URL url = new URL(stringUrl);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        String line;
        StringBuilder jsonString = new StringBuilder();

        uc.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        uc.setRequestMethod("POST");
        uc.setDoInput(true);
        uc.setInstanceFollowRedirects(false);
        uc.connect();
        OutputStreamWriter writer = new OutputStreamWriter(uc.getOutputStream(), "UTF-8");
        writer.write(payload);
        writer.close();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            while((line = br.readLine()) != null){
                jsonString.append(line);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        uc.disconnect();
        return jsonString.toString();
    }

    public void logIn(View view) {
                i = new Intent(view.getContext(), LoginActivity.class);
                startActivity(i);
            }
}





package com.aryan.javaminiproject.datathon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.aryan.javaminiproject.datathon.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class SignUpScreen extends AppCompatActivity {
    private TextInputEditText signup_name,signup_startupname,signup_sector,signup_email,signup_contact,signup_password;
    private Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        Intent intent = getIntent();
        RequestQueue rq = Volley.newRequestQueue(this);
        signup_name = findViewById(R.id.signup_name);
        signup_startupname = findViewById(R.id.signup_startupname);
        signup_sector = findViewById(R.id.signup_sector);
        signup_email = findViewById(R.id.signup_email);
        signup_contact = findViewById(R.id.signup_contact);
        signup_password = findViewById(R.id.signup_password);
        signupBtn = findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(clicked->{
            String name = signup_name.getText().toString();
            String startup_name = signup_startupname.getText().toString();
            String sector = signup_sector.getText().toString();
            String email = signup_email.getText().toString();
            String contact = signup_contact.getText().toString();
            String password = signup_password.getText().toString();

            if (name.isEmpty()||startup_name.isEmpty()||sector.isEmpty()||email.isEmpty()||contact.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
            } else if (!email.contains("@")) {
                Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
            } else{
                try {
                    JSONObject object = new JSONObject();
                    object.put("name", name);
                    object.put("startup_name", startup_name);
                    object.put("sector", sector);
                    object.put("email", email);
                    object.put("contact_number", contact);
                    object.put("password", password);

                    JsonObjectRequest jor = new JsonObjectRequest(
                            Request.Method.POST,
                            "http://10.0.2.2:8080/api/v1/save-founder",
                            object,
                            response -> {
                                Toast.makeText(this,"Signed Up Successfully",Toast.LENGTH_SHORT).show();
                            },
                            error -> {
                                if (error != null && error.networkResponse != null) {
                                    int statusCode = error.networkResponse.statusCode;
                                    if (statusCode ==400){
                                        String responseBody = new String(error.networkResponse.data);
                                        if (responseBody.equals("user already exists with that email")){
                                            signup_email.setError("Email Exists");
                                        }
                                    }
                                }
                                else{
                                    Log.d("myapp", error.getMessage());
                                }
                            }
                    );
                    rq.add(jor);
                }
                catch(Exception e ){
                    e.printStackTrace();
                }
            }
        });
    }
}
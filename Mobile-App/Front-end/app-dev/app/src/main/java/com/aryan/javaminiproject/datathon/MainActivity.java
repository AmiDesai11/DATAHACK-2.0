package com.aryan.javaminiproject.datathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.aryan.javaminiproject.datathon.activities.HomeScreen;
import com.aryan.javaminiproject.datathon.activities.SignUpScreen;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText loginPassword,loginUsername;
    private Button loginBtn;
    private TextView signupbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPassword= findViewById(R.id.password);
        loginUsername = findViewById(R.id.login_username);
        loginBtn = findViewById(R.id.loginBtn);
        signupbutton = findViewById(R.id.signupbutton);

        RequestQueue rq = Volley.newRequestQueue(this);

        loginBtn.setOnClickListener(v->{
            String username = loginUsername.getText().toString();
            String password = loginPassword.getText().toString();
            if (username.isEmpty()||password.isEmpty()){
                loginUsername.setError("Invalid Username");
                loginPassword.setError("Invalid Password");
            }
            else{
                try {
                    JSONObject object = new JSONObject();
                    object.put("email", username);
                    object.put("password", password);
                    JsonObjectRequest jor = new JsonObjectRequest(
                            Request.Method.POST,
                            "http://10.0.2.2:8080/api/v1/login",
                            object,
                            response -> {
                                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                                startActivity(intent);
                                finish();
                            },
                            error -> {
                                if (error != null && error.networkResponse != null) {
                                    int statusCode = error.networkResponse.statusCode;
                                    if (statusCode ==400){
                                        String responseBody = new String(error.networkResponse.data);
                                        if (responseBody.equals("password not matched")){
                                            Toast.makeText(this, "password not matched", Toast.LENGTH_SHORT).show();
                                        } else if (responseBody.equals("not found")) {
                                            Toast.makeText(this, "user not found", Toast.LENGTH_SHORT).show();
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
                catch (Exception e){
                    Log.d("TAG", "hello");
                }
            }
        });
        signupbutton.setOnClickListener(click->{
            Intent i = new Intent(MainActivity.this, SignUpScreen.class);
            startActivity(i);
        });
    }
}
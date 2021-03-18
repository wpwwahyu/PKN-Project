package com.example.ngalam112v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ngalam112v2.login.LoginRequest;
import com.example.ngalam112v2.login.LoginResponse;
import com.example.ngalam112v2.services.ApiClient;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainSignin extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_signin);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progress);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(textInputEditTextUsername.getText().toString()) || TextUtils.isEmpty(textInputEditTextPassword.getText().toString())){
                    Toast.makeText(MainSignin.this, "Username / Password Salah", Toast.LENGTH_LONG).show();
                }
                else{
                    login();
                }
            }
        });
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(textInputEditTextUsername.getText().toString());
        loginRequest.setUsername(textInputEditTextPassword.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getApiService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainSignin.this,"Login Success",Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(MainSignin.this, MainForm.class).putExtra("data", loginResponse.getUsername()));
                        }
                    }, 700);
                }else{
                    Toast.makeText(MainSignin.this,"Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainSignin.this,"Throwable "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
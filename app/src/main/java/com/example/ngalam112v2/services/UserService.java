package com.example.ngalam112v2.services;

import com.example.ngalam112v2.login.LoginResponse;
import com.example.ngalam112v2.login.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("read.php")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}

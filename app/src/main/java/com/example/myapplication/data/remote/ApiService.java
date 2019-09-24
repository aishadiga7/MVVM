package com.example.myapplication.data.remote;

import com.example.myapplication.data.remote.model.LoginResponse;
import com.example.myapplication.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v2/5d8a6dcd3000006500b9a960")
    Call<LoginResponse> login();
}

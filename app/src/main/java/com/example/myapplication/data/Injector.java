package com.example.myapplication.data;

import com.example.myapplication.data.remote.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {
    public static  Repository repository;
    public static ApiService apiService;

    public static void init() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);

        if(repository == null)
            repository = new MainRepositoryImpl(apiService);
    }

    public static Repository getRepository() {
        return repository;
    }

    public static ApiService getApiService() {
        return apiService;
    }
}

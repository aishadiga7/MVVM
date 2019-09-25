package com.example.myapplication.data;

import androidx.room.Room;

import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.common.MyApplication;
import com.example.myapplication.data.local.AppDataBase;
import com.example.myapplication.data.remote.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {
    public static Repository repository;
    public static ApiService apiService;
    public static AppViewModelFacotry appViewModelFacotry;
    public static AppDataBase dataBase;


    public static void init(MyApplication myApplication) {

        initRetrofit();
        initViewModelFactory();
        initDb(myApplication);

        if(repository == null)
            repository = new MainRepositoryImpl(apiService, dataBase);
    }

    private static void initDb(MyApplication myApplication) {
        dataBase = Room.
                 databaseBuilder(myApplication, AppDataBase.class, "app-database")
                .build();


    }

    public static AppDataBase getDataBase() {
        return dataBase;
    }

    private static void initViewModelFactory() {
        appViewModelFacotry = new AppViewModelFacotry();
    }

    public static AppViewModelFacotry getAppViewModelFacotry() {
        return appViewModelFacotry;
    }

    private static void initRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static Repository getRepository() {
        return repository;
    }

    public static ApiService getApiService() {
        return apiService;
    }
}

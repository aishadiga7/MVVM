package com.example.myapplication.di;


import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.data.Repository;
import com.example.myapplication.data.remote.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    public static ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


    @Provides
    @ApplicationScope
    public static Retrofit provideRetrofit(OkHttpClient client,@BaseURL String baseUrl){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    @Provides
    @ApplicationScope
    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        return client;
    }

    @Provides
    @ApplicationScope
    public static HttpLoggingInterceptor provideLogger(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BASIC);
        return logging;
    }





    @Provides
    @BaseURL
    public static String provideBaseURL(){
        return "http://www.mocky.io/";
    }

    @Provides
    @AppName
    public static String provideAppName(){
        return "SampleApp";
    }



}

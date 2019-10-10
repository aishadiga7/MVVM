package com.example.myapplication.common;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.data.Injector;
import com.example.myapplication.di.AppComponent;
import com.example.myapplication.di.DaggerAppComponent;

public class MyApplication extends Application {

    public static Context context;

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.init();
        context = this;
        appComponent = DaggerAppComponent.builder().build();


    }

    public static Context getContext() {
        return context;
    }
}

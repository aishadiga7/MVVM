package com.example.myapplication.common;

import android.app.Application;

import com.example.myapplication.data.Injector;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       Injector.init(this);



    }
}

package com.example.myapplication.di;

import android.app.AppComponentFactory;
import android.content.Context;

import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.common.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FactoryModule {

    @Provides
    public static AppViewModelFacotry provideFactory() {
        return new AppViewModelFacotry();
    }

    @Provides
    public static Context appContext(){
        return MyApplication.context;
    }
}

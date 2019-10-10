package com.example.myapplication.di;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    public static MainActivityObject provideMainActivityObject(){
        return new MainActivityObject();
    }
}

package com.example.myapplication.di;

import com.example.myapplication.views.MainActivity;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {NetworkModule.class, FactoryModule.class})
@ApplicationScope
public interface AppComponent {

    void inject(MainActivity mainActivity);
}

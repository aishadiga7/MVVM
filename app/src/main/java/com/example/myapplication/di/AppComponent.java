package com.example.myapplication.di;

import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.views.MainActivity;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {NetworkModule.class, FactoryModule.class,BindingModule.class})
@ApplicationScope
public interface AppComponent {

    ApiService getApiservice();

}

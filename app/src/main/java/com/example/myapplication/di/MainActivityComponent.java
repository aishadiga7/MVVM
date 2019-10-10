package com.example.myapplication.di;


import com.example.myapplication.views.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {MainActivityModule.class}, dependencies = {AppComponent.class})
public interface MainActivityComponent {


    void inject(MainActivity mainActivity);

}

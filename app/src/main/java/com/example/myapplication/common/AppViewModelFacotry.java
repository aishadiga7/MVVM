package com.example.myapplication.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.Injector;
import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.viewmodel.HomeViewModel;
import com.example.myapplication.viewmodel.LoginViewModel;

import javax.inject.Inject;

public class AppViewModelFacotry implements ViewModelProvider.Factory {


    @Inject
    public AppViewModelFacotry() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if (modelClass == LoginViewModel.class) {
           return (T) new LoginViewModel(Injector.getRepository());
       } else if (modelClass == HomeViewModel.class){
           return (T) new HomeViewModel(Injector.getRepository());
       }


       return null;

    }
}

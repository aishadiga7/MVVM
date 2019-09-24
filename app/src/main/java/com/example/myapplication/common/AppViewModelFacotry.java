package com.example.myapplication.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.viewmodel.LoginViewModel;

public class AppViewModelFacotry implements ViewModelProvider.Factory {




    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if (modelClass == LoginViewModel.class) {
           return (T) new LoginViewModel(new MainRepositoryImpl());
       } else {
           return null;
       }

    }
}

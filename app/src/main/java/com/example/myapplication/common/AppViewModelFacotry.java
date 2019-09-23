package com.example.myapplication.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.views.LoginView;

public class AppViewModelFacotry implements ViewModelProvider.Factory {


    private LoginView loginView;// NOTYE: don't do like this

    public AppViewModelFacotry(LoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * This is the function whioch gets called when you call
     * <p>
     * ViewModelsProviders.of().get(Myclass.class)
     *
     * @param modelClass
     * @param <T>
     * @return
     */

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      return null;
    }
}

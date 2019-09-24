package com.example.myapplication.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Repository;

public class HomeViewModel extends ViewModel {

    private Repository repository;

    public HomeViewModel(Repository repository) {

        this.repository = repository;
    }
}

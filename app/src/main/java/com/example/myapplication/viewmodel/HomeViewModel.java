package com.example.myapplication.viewmodel;



import com.example.myapplication.data.Repository;

public class HomeViewModel extends BaseViewModel {

    private Repository repository;


    public HomeViewModel(Repository repository) {
        this.repository = repository;
    }


}

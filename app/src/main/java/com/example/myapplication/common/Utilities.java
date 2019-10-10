package com.example.myapplication.common;

import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.di.ApplicationScope;

import javax.inject.Inject;

@ApplicationScope
public class Utilities {

    DbManager dbManager;


    @Inject
    public Utilities() {

    }

    @Inject
    public void setDbManager(DbManager dbManager) {
        this.dbManager = dbManager;
    }
}

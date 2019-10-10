package com.example.myapplication.common;

import com.example.myapplication.di.ApplicationScope;

import javax.inject.Inject;

@ApplicationScope
public class DbManager {

    @Inject
    public DbManager() {
    }
}

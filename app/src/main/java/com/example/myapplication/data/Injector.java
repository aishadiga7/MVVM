package com.example.myapplication.data;

public class Injector {
    public static  Repository repository;

    public static Repository getRepository() {
        if(repository == null)
            repository = new MainRepositoryImpl();
        return repository;
    }
}

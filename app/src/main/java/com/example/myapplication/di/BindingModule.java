package com.example.myapplication.di;

import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.data.Repository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface BindingModule {

    @Binds
    Repository provideRepository(MainRepositoryImpl repository);
}

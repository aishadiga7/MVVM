package com.example.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    private MutableLiveData<Boolean> progressLiveData = new MutableLiveData<>();

    public LiveData<Boolean> getProgressLiveData() {
        return progressLiveData;
    }

    protected void setProgress(boolean isLoading) {
        progressLiveData.setValue(isLoading);
    }
}

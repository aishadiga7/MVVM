package com.example.myapplication.viewmodel;

import android.os.AsyncTask;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Callback;
import com.example.myapplication.data.Repository;
import com.example.myapplication.model.User;
import com.example.myapplication.views.uimodel.Result;

public class LoginViewModel extends ViewModel {
    private Repository repository;
    MutableLiveData<Result<User>> liveData = new MutableLiveData<>();
    MutableLiveData<Boolean> progressLiveData = new MutableLiveData<>();


    public LiveData<Result<User>> getLoginLiveData() {
        return liveData;
    }

    public LiveData<Boolean> getProgressLiveData() {
        return progressLiveData;
    }

    public LoginViewModel(Repository repository) {
        this.repository = repository;
    }


    public void performLogin(String userName, String password) {
        progressLiveData.setValue(true);
        if (validInputs(userName,  password)) {
            repository.login(userName, password, new Callback<User>() {

                @Override
                public void onSuccess(User result) {
                    progressLiveData.setValue(false);
                    repository.saveUser(result);
                    Result<User> userResult = new Result<User>();
                    userResult.setResult(result);
                    userResult.setIsSuccess(true);
                    liveData.setValue(userResult);
                }

                @Override
                public void onError(Throwable error) {
                    progressLiveData.setValue(false);
                    Result<User> userResult = new Result<User>();
                    userResult.setError(error);
                    userResult.setIsSuccess(false);
                    liveData.setValue(userResult);
                }
            });
        } else {
            progressLiveData.setValue(false);
            Result<User> userResult = new Result<User>();
            userResult.setError(new Error("Invalid inputs"));
            userResult.setIsSuccess(false);
            liveData.setValue(userResult);
        }
    }

    private boolean validInputs(String userName, String password) {
        return !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password);
    }
}

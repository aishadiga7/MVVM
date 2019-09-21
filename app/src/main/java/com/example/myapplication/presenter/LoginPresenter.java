package com.example.myapplication.presenter;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Callback;
import com.example.myapplication.data.Repository;
import com.example.myapplication.model.User;
import com.example.myapplication.views.LoginView;
import com.example.myapplication.views.MainActivity;

public class LoginPresenter extends ViewModel {

    private Repository repository;
    private LoginView loginView;


    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performLogin(String userName, String password) {
        if (validInputs(userName, password)) {
            loginView.showLoader();
            repository.login(userName, password, new Callback<User>() {
                @Override
                public void onSuccess(User result) {
                    // here I decide to cache the result
                    repository.saveUser(result);
                    loginView.dismissLoader();
                    loginView.showMessage("Welcome " + result.firstName + " " + result.lastName);

                }

                @Override
                public void onError(Throwable error) {
                    loginView.dismissLoader();
                    loginView.showMessage("Something went wrong, "+ error.getMessage());
                }
            });


        } else {
            loginView.showMessage("Invalid inputs");
        }
    }

    private boolean validInputs(String userName, String password) {

        return !userName.isEmpty() && !password.isEmpty();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(MainActivity.TAG, "onCleared called, view model destroyed: ");
    }
}

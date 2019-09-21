package com.example.myapplication.presenter;

import com.example.myapplication.data.Callback;
import com.example.myapplication.data.Repository;
import com.example.myapplication.model.User;
import com.example.myapplication.views.LoginView;

public class LoginPresenter {

    private Repository repository;
    private LoginView loginView;


    public LoginPresenter(Repository repository, LoginView loginView) {
        this.repository = repository;
        this.loginView = loginView;
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


}

package com.example.myapplication.data;

import com.example.myapplication.model.User;

/*
This interface contains methods to interact with the inner layer
 */
public interface Repository {

    void login(String usename, String password, Callback<User> callback);

    /**
     * This method will save the User object locally
     * @param user
     */
    void saveUser(User user);

    void getUser();

}

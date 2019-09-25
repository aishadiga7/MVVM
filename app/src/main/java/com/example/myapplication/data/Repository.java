package com.example.myapplication.data;

import com.example.myapplication.model.Product;
import com.example.myapplication.model.User;

import java.util.List;

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


    void getProducts(Callback<List<Product>> callback);
}

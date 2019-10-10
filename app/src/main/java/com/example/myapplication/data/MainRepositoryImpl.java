package com.example.myapplication.data;

import android.app.Activity;
import android.content.Context;

import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.data.remote.model.LoginResponse;
import com.example.myapplication.data.remote.remote.model.ItemListResponse;
import com.example.myapplication.data.remote.remote.model.ProductResponse;
import com.example.myapplication.di.ApplicationScope;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/*
This class will iomplement the repository interface and doers the actual logic of it
 */
@ApplicationScope
public class MainRepositoryImpl implements Repository {

    // this hashmap mocks the shared preference
    private static HashMap<String, Object> preference = new HashMap<>();
    private static boolean mockError = false; // just a flag to mock error
    private ApiService apiService;

    @Inject
    public MainRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }
    /*
    This method intercats with the backend server and gets the login result
     */

    @Override
    public void login(String usename, String password, final Callback<User> callback) {
        apiService.login().enqueue(new retrofit2.Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response != null && response.isSuccessful()) {
                    LoginResponse.UserResponse loginresponse = response.body().user;
                    User user = new User();
                    user.firstName = loginresponse.first_name;
                    user.lastName = loginresponse.last_name;
                    callback.onSuccess(user);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onError(t);
            }
        });

    }

    @Override
    public void saveUser(User user) {
        preference.put(PreferenceKeys.USER, user);
    }

    @Override
    public void getUser() {
        preference.get(PreferenceKeys.USER);
    }

    @Override
    public void getProducts(Callback<List<Product>> callback) {
        apiService.getProducts().enqueue(new retrofit2.Callback<ItemListResponse>() {
            @Override
            public void onResponse(Call<ItemListResponse> call, Response<ItemListResponse> response) {
                if (response != null && response.isSuccessful()) {
                   preference.put(PreferenceKeys.NEWARRIVAL,response.body().newarrival);
                   List<Product> productsList = new ArrayList<>();
                    for (ProductResponse watch : response.body().watches) {
                        Product product = new Product();
                        product.setName(watch.brand);
                        product.setDescription(watch.model);
                        product.setPrice(watch.price);
                        product.setUrl(watch.image);
                        productsList.add(product);
                    }
                    if(callback != null) {
                        callback.onSuccess(productsList);
                    }
                }
            }

            @Override
            public void onFailure(Call<ItemListResponse> call, Throwable t) {
                if (callback != null) {
                    callback.onError(t);
                }
            }
        });
    }

    @Override
    public ProductResponse.Newarrival geNewArrivals() {
        return (ProductResponse.Newarrival) preference.get(PreferenceKeys.NEWARRIVAL);
    }


    public static class PreferenceKeys {
        public static final String USER = "user";
        public static final String NEWARRIVAL = "newarrival";
    }
}

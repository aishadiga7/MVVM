package com.example.myapplication.data;

import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.data.remote.model.LoginResponse;
import com.example.myapplication.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;

/*
This class will iomplement the repository interface and doers the actual logic of it
 */
public class MainRepositoryImpl implements Repository {

    // this hashmap mocks the shared preference
    private static HashMap<String, Object> preference = new HashMap<>();
    private static boolean mockError = false; // just a flag to mock error
    private ApiService apiService;

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


    public static class PreferenceKeys {
        public static final String USER = "user";
    }
}

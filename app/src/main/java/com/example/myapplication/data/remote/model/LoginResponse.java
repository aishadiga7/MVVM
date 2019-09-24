package com.example.myapplication.data.remote.model;


import com.google.gson.annotations.SerializedName;

public class LoginResponse
{
    @SerializedName("is_success")
    public boolean is_success;
    @SerializedName("user")
    public UserResponse user;


    public class UserResponse
    {
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
    }
}


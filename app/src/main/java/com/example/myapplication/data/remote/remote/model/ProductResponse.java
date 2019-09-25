package com.example.myapplication.data.remote.remote.model;

import com.google.gson.annotations.SerializedName;

public class ProductResponse
{
    @SerializedName("brand")
    public String brand;
    @SerializedName("model")
    public String model;
    @SerializedName("price")
    public String price;
    @SerializedName("image")
    public String image;
    public class Newarrival
    {
        @SerializedName("product")
        public String product;
        @SerializedName("model")
        public String model;
        @SerializedName("image")
        public String image;
        @SerializedName("about")
        public String about;
    }
}




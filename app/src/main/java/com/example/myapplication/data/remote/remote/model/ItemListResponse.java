package com.example.myapplication.data.remote.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemListResponse
{
    @SerializedName("watches")
    public List<ProductResponse> watches;
    @SerializedName("newarrival")
    public ProductResponse.Newarrival newarrival;
}

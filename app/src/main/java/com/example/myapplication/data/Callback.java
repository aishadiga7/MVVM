package com.example.myapplication.data;

/*
This is a generic callback interface, which can be resued for all api calls or any other
asynchronus operations, to return the result,

T can be changed to any model you want, so that we can avoid creating new new interface for every api calls
 */
public interface Callback<T> {

    void onSuccess(T result);

    void onError(Throwable error);

}

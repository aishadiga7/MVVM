package com.example.myapplication.views.uimodel;

public abstract class Result<T> {

    T result;
    Throwable error;

    public void setError(Throwable error) {
        this.error = error;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }


    public Throwable getError() {
        return error;
    }

    private boolean isSuccess;

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isSuccess() {
        return isSuccess;
    }



}

package com.example.myapplication.viewmodel;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Callback;

public class LoginViewModel extends ViewModel {


   MutableLiveData<String> apiResult = new MutableLiveData<>();

    public MutableLiveData<String> getApiResult() {
        return apiResult;
    }


    public void init(){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                apiResult.setValue("Result received!");

            }
        }.execute();
    }

}

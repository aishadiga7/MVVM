package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.data.Callback;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.viewmodel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity_Log";
    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);


        loginViewModel.init();

        loginViewModel.getApiResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });








            
    }

}

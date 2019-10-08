package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.common.Navigator;
import com.example.myapplication.common.Router;
import com.example.myapplication.data.Repository;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {
    @Inject
    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Navigator navigator = new Router(this);
        new Handler().postDelayed(()-> {
                navigator.launchLoginScreen();
        }, 5000);


    }
}

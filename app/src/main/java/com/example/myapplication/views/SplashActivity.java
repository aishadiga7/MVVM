package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.common.Navigator;
import com.example.myapplication.common.Router;

public class SplashActivity extends AppCompatActivity {

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

package com.example.myapplication.common;

import android.app.Activity;
import android.content.Intent;

import com.example.myapplication.views.HomeActivity;
import com.example.myapplication.views.MainActivity;

public class Router implements Navigator {

    Activity activity;

    public Router(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void launchHomeActicvity() {
        activity.startActivity(new Intent(activity, HomeActivity.class));
    }

    @Override
    public void launchLoginScreen() {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
}

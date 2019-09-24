package com.example.myapplication.views;

import android.os.Bundle;

import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.databinding.ActivityHomeBinding;
import com.example.myapplication.viewmodel.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding mBinding;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        AppViewModelFacotry appViewModelFacotry = new AppViewModelFacotry();
        homeViewModel = ViewModelProviders.of(this, appViewModelFacotry).get(HomeViewModel.class);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }
}

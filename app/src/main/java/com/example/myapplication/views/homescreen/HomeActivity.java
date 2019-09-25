package com.example.myapplication.views.homescreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.databinding.ActivityHomeBinding;
import com.example.myapplication.viewmodel.HomeViewModel;
import com.example.myapplication.views.adapter.ViewpagerAdapter;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding mBinding;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        AppViewModelFacotry appViewModelFacotry = new AppViewModelFacotry();
        homeViewModel = ViewModelProviders.of(this, appViewModelFacotry).get(HomeViewModel.class);
        setUpViewPager();
        homeViewModel.fetchData();


    }

    private void setUpViewPager() {
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        mBinding.viewPager.setAdapter(viewpagerAdapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.unbind();
    }
}

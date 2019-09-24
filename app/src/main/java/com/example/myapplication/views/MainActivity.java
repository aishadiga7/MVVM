package com.example.myapplication.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.User;
import com.example.myapplication.viewmodel.LoginViewModel;
import com.example.myapplication.views.uimodel.Result;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity_Log";
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.loaderGroup.setVisibility(View.GONE);
        AppViewModelFacotry facotry = new AppViewModelFacotry();
        loginViewModel = ViewModelProviders.of(this, facotry).get(LoginViewModel.class);

        loginViewModel.getLoginLiveData().observe(this, new Observer<Result<User>>() {
            @Override
            public void onChanged(Result<User> result) {
                if (result.isSuccess()) {
                    User user = result.getResult();
                    Toast.makeText(MainActivity.this, user.firstName+ " "+user.lastName, Toast.LENGTH_SHORT).show();

                }else {

                }

            }
        });

        loginViewModel.getProgressLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean s) {
                mBinding.loaderGroup.setVisibility(s ? View.VISIBLE : View.GONE);
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.performLogin(mBinding.userName.getText().toString(), mBinding.password.getText().toString());
            }
        });

    }

}

package com.example.myapplication.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.common.AppViewModelFacotry;
import com.example.myapplication.common.MyApplication;
import com.example.myapplication.common.Navigator;
import com.example.myapplication.common.Router;
import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.data.Repository;
import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.di.AppName;
import com.example.myapplication.model.User;
import com.example.myapplication.viewmodel.LoginViewModel;
import com.example.myapplication.views.uimodel.Result;

import javax.inject.Inject;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity_Log";
    private LoginViewModel loginViewModel;


   @Inject
   AppViewModelFacotry  facotry;

   @Inject
   @AppName
   String appName;

   @Inject
   Repository repository;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyApplication.appComponent.inject(this);


        loginViewModel = ViewModelProviders.of(this, facotry).get(LoginViewModel.class);
        mBinding.setViewModel(loginViewModel);
        mBinding.setLifecycleOwner(this);
        loginViewModel.getLoginLiveData().observe(this, new Observer<Result<User>>() {
            @Override
            public void onChanged(Result<User> result) {
                if (result.isSuccess()) {
                    User user = result.getResult();
                    Toast.makeText(MainActivity.this, user.firstName+ " "+user.lastName, Toast.LENGTH_SHORT).show();
                    Navigator navigator = new Router(MainActivity.this);
                    navigator.launchHomeScreen(user.firstName);
                } else {
                    Toast.makeText(MainActivity.this, result.getError().getMessage(), Toast.LENGTH_SHORT).show();
                }

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

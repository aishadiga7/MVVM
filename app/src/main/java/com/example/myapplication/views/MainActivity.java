package com.example.myapplication.views;

import android.os.Bundle;
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
import com.example.myapplication.data.Repository;
import com.example.myapplication.data.remote.ApiService;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.di.DaggerMainActivityComponent;
import com.example.myapplication.di.MainActivityComponent;
import com.example.myapplication.di.MainActivityObject;
import com.example.myapplication.model.User;
import com.example.myapplication.viewmodel.LoginViewModel;
import com.example.myapplication.views.uimodel.Result;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    public static final String TAG = "MainActivity_Log";
    private LoginViewModel loginViewModel;



    @Inject
    MainActivityObject object;

    @Inject
    ApiService apiService;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .appComponent(MyApplication.appComponent)
                .build();

        component.inject(this);


        loginViewModel = ViewModelProviders.of(this, new AppViewModelFacotry()).get(LoginViewModel.class);
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

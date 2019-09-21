package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.MainRepositoryImpl;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginView{
    ActivityMainBinding mBinding;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
         dismissLoader();

        final LoginPresenter presenter = new LoginPresenter(new MainRepositoryImpl(),this);
        Log.d(TAG, "onCreate: Presenter created"+ presenter);

        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = mBinding.password.getText().toString();
                String userName = mBinding.userName.getText().toString();
                presenter.performLogin(userName, password);
            }
        });

    }




    @Override
    public void showLoader() {
        mBinding.loaderGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoader() {
        mBinding.loaderGroup.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}

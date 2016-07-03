package com.example.irfan.firebaseapp.mvvm.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.irfan.firebaseapp.BaseActivity;
import com.example.irfan.firebaseapp.R;

public class LoginActivity extends BaseActivity<LoginController> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    protected int getResLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected LoginController createController() {
        return new LoginController();
    }
}

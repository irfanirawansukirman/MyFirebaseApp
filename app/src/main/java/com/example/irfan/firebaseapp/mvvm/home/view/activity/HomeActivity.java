package com.example.irfan.firebaseapp.mvvm.home.view.activity;

import com.example.irfan.firebaseapp.BaseActivity;
import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;

public class HomeActivity extends BaseActivity<HomeController> {

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.home_activity;
    }

    @Override
    protected HomeController createController() {
        return new HomeController();
    }
}

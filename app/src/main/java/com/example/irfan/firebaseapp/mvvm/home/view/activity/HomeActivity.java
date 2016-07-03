package com.example.irfan.firebaseapp.mvvm.home.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.irfan.firebaseapp.BaseActivity;
import com.example.irfan.firebaseapp.BaseMessage;
import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.view.adapter.HomeAdapter;
import com.example.irfan.firebaseapp.mvvm.home.viewmodel.HomeVM;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mController.onDestroyListener();
    }

    public static void startThisActivity(Context mContext){
        Intent intent = new Intent(mContext, HomeActivity.class);
        mContext.startActivity(intent);
    }
}

package com.example.irfan.firebaseapp.mvvm.home;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.irfan.firebaseapp.R;

import id.gits.mvvmcore.activity.GitsActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }
}

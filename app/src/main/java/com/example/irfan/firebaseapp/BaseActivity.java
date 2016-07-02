package com.example.irfan.firebaseapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.firebase.client.Firebase;

import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.mvvmcore.controller.GitsController;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by irfan on 01/07/16.
 */
public abstract class BaseActivity<C extends GitsController> extends GitsActivity<C> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Firebase.setAndroidContext(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

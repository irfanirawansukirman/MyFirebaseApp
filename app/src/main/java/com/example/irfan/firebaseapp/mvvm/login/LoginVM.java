package com.example.irfan.firebaseapp.mvvm.login;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.irfan.firebaseapp.databinding.LoginActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.view.activity.HomeActivity;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 04/07/16.
 */
public class LoginVM extends GitsVM<LoginController, LoginActivityBinding> {
    public LoginVM(AppCompatActivity activity, LoginController controller, LoginActivityBinding binding) {
        super(activity, controller, binding);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mActivity.finish();
                HomeActivity.startThisActivity(mActivity);
            }
        }, 2000);
    }
}

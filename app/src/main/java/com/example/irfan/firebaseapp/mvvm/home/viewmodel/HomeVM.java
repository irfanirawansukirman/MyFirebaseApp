package com.example.irfan.firebaseapp.mvvm.home.viewmodel;

import android.support.v7.app.AppCompatActivity;

import com.example.irfan.firebaseapp.databinding.HomeActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 01/07/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> {

    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
    }
}

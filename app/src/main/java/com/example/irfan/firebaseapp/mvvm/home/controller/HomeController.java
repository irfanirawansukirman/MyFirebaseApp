package com.example.irfan.firebaseapp.mvvm.home.controller;

import com.example.irfan.firebaseapp.databinding.HomeActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.viewmodel.HomeVM;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by irfan on 01/07/16.
 */
public class HomeController extends GitsController<HomeVM, HomeActivityBinding> {

    @Override
    public HomeVM createViewModel(HomeActivityBinding binding) {
        return new HomeVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(HomeActivityBinding binding, HomeVM viewModel) {
        binding.setVm(viewModel);
    }
}

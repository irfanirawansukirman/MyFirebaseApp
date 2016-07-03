package com.example.irfan.firebaseapp.mvvm.home.viewmodel;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.irfan.firebaseapp.databinding.HomeActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.view.adapter.HomeChatAdapter;

import java.util.ArrayList;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 01/07/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> {
    public LinearLayoutManager mLinearLayoutManager;
    public ArrayList<MessageModel> mData;
    public HomeChatAdapter mAdapter;

    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
        onChatContent();
    }

    public void onChatContent(){
        mData = new ArrayList<>();
        mAdapter = new HomeChatAdapter(mData);
        mLinearLayoutManager = new LinearLayoutManager(mActivity);
        mAdapter.notifyDataSetChanged();
    }
}

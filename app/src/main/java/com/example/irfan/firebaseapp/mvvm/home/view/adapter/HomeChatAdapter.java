package com.example.irfan.firebaseapp.mvvm.home.view.adapter;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.databinding.RowAingBinding;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.viewmodel.HomeAingRowVM;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by irfan on 03/07/16.
 */
public class HomeChatAdapter extends GitsAdapter<MessageModel, HomeAingRowVM, RowAingBinding> {

    public HomeChatAdapter(List<MessageModel> collection) {
        super(collection);
    }

    @Override
    public HomeAingRowVM createViewModel(AppCompatActivity activity, RowAingBinding binding, MessageModel item, int position) {
        return new HomeAingRowVM(mContext, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_aing;
    }

    @Override
    public void render(RowAingBinding binding, HomeAingRowVM viewModel, MessageModel item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(MessageModel data, int position) {

    }
}

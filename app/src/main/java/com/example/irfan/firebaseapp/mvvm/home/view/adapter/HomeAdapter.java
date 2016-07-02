package com.example.irfan.firebaseapp.mvvm.home.view.adapter;

import android.support.v7.app.AppCompatActivity;

import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.databinding.RowAingBinding;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.viewmodel.HomeAingRowVM;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by Irfan Irawan S on 02-Jul-16.
 */
public class HomeAdapter extends GitsAdapter<MessageModel, HomeAingRowVM, RowAingBinding> {

    public HomeAdapter(List<MessageModel> collection) {
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

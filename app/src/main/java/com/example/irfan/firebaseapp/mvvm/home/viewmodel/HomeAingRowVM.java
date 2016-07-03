package com.example.irfan.firebaseapp.mvvm.home.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.irfan.firebaseapp.databinding.RowAingBinding;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Irfan Irawan S on 02-Jul-16.
 */
public class HomeAingRowVM extends GitsRowVM<MessageModel, RowAingBinding> {
    public ObservableField<String> mSenderName = new ObservableField<>("");
    public ObservableField<String> mDate = new ObservableField<>("");
    public ObservableField<String> mMessage = new ObservableField<>("");

    public HomeAingRowVM(Context context, RowAingBinding binding, MessageModel data) {
        super(context, binding, data);
        mSenderName.set(data.getmSender());
        mDate.set(String.valueOf(data.getmDate()));
        mMessage.set(data.getmText());
    }
}

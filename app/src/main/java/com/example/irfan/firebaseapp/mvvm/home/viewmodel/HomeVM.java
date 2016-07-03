package com.example.irfan.firebaseapp.mvvm.home.viewmodel;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.irfan.firebaseapp.BaseMessage;
import com.example.irfan.firebaseapp.databinding.HomeActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.view.adapter.HomeChatAdapter;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 01/07/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> implements BaseMessage.MessageCallbacks {
    public LinearLayoutManager mLinearLayoutManager;
    public ArrayList<MessageModel> mData;
    public HomeChatAdapter mAdapter;
    public String mConvoId;
    public BaseMessage.MessageListener mListener;

    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
        Firebase.setAndroidContext(mActivity);
        onChatContent();
    }

    public void onChatContent(){
        mData = new ArrayList<>();
        mAdapter = new HomeChatAdapter(mData);
        mLinearLayoutManager = new LinearLayoutManager(mActivity);
        mBinding.recHomeChat.setHasFixedSize(true);

        mAdapter.notifyDataSetChanged();

        String[] ids = {"Komar", "-", "Dadang"};
        Arrays.sort(ids);
        mConvoId = ids[0]+ids[1]+ids[2];
        mListener = BaseMessage.addMessageListener(mConvoId, this);
    }

    @Override
    public void onMessageAdded(MessageModel mMessageModel) {
        mData.add(mMessageModel);
        mAdapter.notifyDataSetChanged();
    }

    public void onSendChat(View view){
        String mMessage = mBinding.edTxtHomeChat.getText().toString();
        mBinding.edTxtHomeChat.setText("");
        MessageModel mMessageData = new MessageModel();
        mMessageData.setmDate(new Date());
        mMessageData.setmText(mMessage);
        mMessageData.setmSender("Kang Dadang");
        BaseMessage.saveMessage(mMessageData, mConvoId);

        mAdapter.notifyDataSetChanged();
    }

    public void onDestroyListener(){
        BaseMessage.stopProcess(mListener);
    }
}

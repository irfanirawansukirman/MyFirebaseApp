package com.example.irfan.firebaseapp.mvvm.home.viewmodel;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.irfan.firebaseapp.BaseMessage;
import com.example.irfan.firebaseapp.databinding.HomeActivityBinding;
import com.example.irfan.firebaseapp.mvvm.home.controller.HomeController;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.view.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 01/07/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> implements BaseMessage.MessageCallbacks{
    public static final String USER_EXTRA = "USER";
    public static final String TAG = "ChatHome";
    private ArrayList<MessageModel> mMessage;
    private HomeAdapter mAdapter;
    private String mRecipient;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(mActivity);
    private Date mLastMessageDate = new Date();
    private String mConvoId;
    private BaseMessage.MessageListener mListener;

    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
        onChatMessage();
    }

    public void onChatMessage(){
        mMessage = new ArrayList<>();
        mAdapter = new HomeAdapter(mMessage);
        String[] ids = {"Enjang", "-", "Badrun"};
        Arrays.sort(ids);
        mConvoId = ids[0] + ids[1] + ids[2];
        mListener = BaseMessage.addMessageListener(mConvoId, this);
    }

    @Override
    public void onMessageAdded(MessageModel mMessageModel) {
        mMessage.add(mMessageModel);
        mAdapter.notifyDataSetChanged();
    }

    public void onSendChat(View view){
        String mNewMessage = mBinding.edTxtHomeChat.getText().toString();
        mBinding.edTxtHomeChat.setText("");
        MessageModel mMessage = new MessageModel();
        mMessage.setmDate(new Date());
        mMessage.setmText(mNewMessage);
        mMessage.setmSender("Irfan");
        BaseMessage.saveMessage(mMessage, mConvoId);
    }
}

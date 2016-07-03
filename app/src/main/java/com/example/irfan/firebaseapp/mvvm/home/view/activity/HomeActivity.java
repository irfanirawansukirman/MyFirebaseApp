package com.example.irfan.firebaseapp.mvvm.home.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.irfan.firebaseapp.BaseMessage;
import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.mvvm.home.view.adapter.HomeAdapter;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements BaseMessage.MessageCallbacks {
    public Context mContext = this;
    public static final String USER_EXTRA = "USER";
    public static final String TAG = "HomeActivity";
    private ArrayList<MessageModel> mMessageModels;
    private HomeAdapter mAdapter;
    private String mRecipient;
    private Date mLastMessageDate = new Date();
    private String mConvoId;
    private BaseMessage.MessageListener mListener;

    @Bind(R.id.rec_home_chat)
    RecyclerView mRecyclerView;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.edTxt_home_chat)
    EditText mTxtMessage;

    @OnClick(R.id.img_chat_send)
    public void onSendChat(){
        String mMessage = mTxtMessage.getText().toString();
        mTxtMessage.setText("");
        MessageModel mMessageData = new MessageModel();
        mMessageData.setmDate(new Date());
        mMessageData.setmText(mMessage);
        mMessageData.setmSender("Kang Dadang");
        BaseMessage.saveMessage(mMessageData, mConvoId);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        initToolbar();
        onConfig();
        playTheChat();
    }

    public void initToolbar(){
        if (mToolbar!=null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public void onConfig(){
        Firebase.setAndroidContext(mContext);
    }

    public void playTheChat(){
        mRecipient = "Kang Dadang";
        mMessageModels = new ArrayList<>();
        mAdapter = new HomeAdapter(mContext, mMessageModels);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        String[] ids = {"Komar", "-", "Dadang"};
        Arrays.sort(ids);
        mConvoId = ids[0]+ids[1]+ids[2];
        mListener = BaseMessage.addMessageListener(mConvoId, this);
    }

    @Override
    public void onMessageAdded(MessageModel mMessageModel) {
        mMessageModels.add(mMessageModel);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseMessage.stopProcess(mListener);
    }
}

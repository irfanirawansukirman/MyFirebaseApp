package com.example.irfan.firebaseapp;

import android.util.Log;

import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;
import com.example.irfan.firebaseapp.util.Constant;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Irfan Irawan S on 02-Jul-16.
 */
public class BaseMessage {
    private static final Firebase mFirebase = new Firebase(Constant.FIREBASE_BASE);
    private static SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(Constant.FORMAT_DATE);
    private static final String TAG = "MessageDataSource";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_SENDER = "sender";

    public static void saveMessage(MessageModel mMessageModel, String convoId){
        Date mDate = mMessageModel.getmDate();
        String mKey = mSimpleDateFormat.format(mDate);
        HashMap<String, String> mMessage = new HashMap<>();
        mMessage.put(COLUMN_TEXT, mMessageModel.getmText());
        mMessage.put(COLUMN_SENDER, "Dodol Garut");
        mFirebase.child(convoId).child(mKey).setValue(mMessage);
    }

    public static MessageListener addMessageListener(String convoId, final MessageCallbacks callbacks){
        MessageListener mMessageListener = new MessageListener(callbacks);
        mFirebase.child(convoId).addChildEventListener(mMessageListener);
        return mMessageListener;
    }

    public static void stopProcess(MessageListener mMessageListener){
        mFirebase.removeEventListener(mMessageListener);
    }

    public static class MessageListener implements ChildEventListener {
        private MessageCallbacks callbacks;

        public MessageListener(MessageCallbacks callbacks){
            this.callbacks=callbacks;
        }

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            HashMap<String, String> mMessage = (HashMap<String, String>) dataSnapshot.getValue();
            MessageModel mMessageModel = new MessageModel();
            mMessageModel.setmSender(mMessage.get(COLUMN_SENDER));
            mMessageModel.setmText(mMessage.get(COLUMN_TEXT));
            try {
                mMessageModel.setmDate(mSimpleDateFormat.parse(dataSnapshot.getKey()));
            } catch (Exception e){
                Log.d(TAG, "Couldn't parse date " + e);
            }

            if (callbacks!=null){
                callbacks.onMessageAdded(mMessageModel);
            }
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(FirebaseError firebaseError) {

        }
    }

    public interface MessageCallbacks{
        public void onMessageAdded(MessageModel mMessageModel);
    }
}

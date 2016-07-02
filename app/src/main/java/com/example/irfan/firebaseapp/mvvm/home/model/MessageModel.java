package com.example.irfan.firebaseapp.mvvm.home.model;

import java.util.Date;

/**
 * Created by Irfan Irawan S on 02-Jul-16.
 */
public class MessageModel {

    private String mText;
    private String mSender;
    private Date mDate;

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }
}

package com.example.irfan.firebaseapp.mvvm.home.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.irfan.firebaseapp.R;
import com.example.irfan.firebaseapp.mvvm.home.model.MessageModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Irawan S on 02-Jul-16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    public Context mContext;
    public MessageModel mItem;
    public ArrayList<MessageModel> mData = new ArrayList<>();

    public HomeAdapter(Context mContext, ArrayList<MessageModel> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.row_aing, parent, false);
        HomeViewHolder mHolder = new HomeViewHolder(mView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        mItem = mData.get(position);

        holder.mTxtName.setText(mItem.getmSender());
        holder.mTxtDate.setText(String.valueOf(mItem.getmDate()));
        holder.mTxtMessage.setText(mItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txt_chat_nameSender)
        TextView mTxtName;
        @Bind(R.id.txt_chat_date)
        TextView mTxtDate;
        @Bind(R.id.txt_chat_message)
        TextView mTxtMessage;

        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

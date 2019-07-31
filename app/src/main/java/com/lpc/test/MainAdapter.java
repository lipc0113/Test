package com.lpc.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 16:36 2019-07-29
 * @ Description：
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<Bean> mList;

    public MainAdapter(Context mContext, List<Bean> list) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        mList = list;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
         * 当我们传进来的root不是null，并且第三个参数是false的时候，这个temp就被加入到了root中，
         * 但返回的是temp，当参三true的时候返回root;root为null的时候，第三个参数不起作用
         * */
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int position) {
        Bean bean = mList.get(position);
        viewHolder.btn.setText(bean.getName());
        viewHolder.btn.setOnClickListener(bean.getOnClickListener());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}

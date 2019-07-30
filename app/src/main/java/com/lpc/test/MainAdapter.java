package com.lpc.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int position) {
        Bean bean = mList.get(position);
        viewHolder.tv.setText(bean.getName());
        viewHolder.tv.setOnClickListener(bean.getOnClickListener());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}

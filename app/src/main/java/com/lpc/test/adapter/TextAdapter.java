package com.lpc.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.R;
import com.lpc.test.bean.TextBean;

import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:13 2019-07-31
 * @ Description：只包含一个text
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {

    private Context mContext;
    private List<TextBean> mList;
    private final LayoutInflater mLayoutInflater;

    public TextAdapter(Context context, List<TextBean> list) {

        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(mList.get(position).getName());
        holder.tv.setOnClickListener(mList.get(position).getOnClickListener());
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

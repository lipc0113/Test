package com.lpc.test.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.R;
import com.lpc.test.adapter.MyRecyclerViewAdapter;
import com.lpc.test.bean.RecyclerViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:09 2019-07-31
 * @ Description：
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<RecyclerViewBean> mList = new ArrayList<>();
    private MyRecyclerViewAdapter mMainAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initView();
        initData();
    }

    private void initData() {

        for (int i = 0; i < 30; i++) {
            RecyclerViewBean bean = new RecyclerViewBean();
            bean.setName("lipc" + i);
            mList.add(bean);
        }

        mMainAdapter = new MyRecyclerViewAdapter(this, mList);
        mRv.setAdapter(mMainAdapter);
    }

    private void initView() {
        mRv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
    }
}

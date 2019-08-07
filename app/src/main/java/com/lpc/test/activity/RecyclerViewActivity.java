package com.lpc.test.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.BaseActivity;
import com.lpc.test.R;
import com.lpc.test.adapter.Main2Adapter;
import com.lpc.test.bean.Main2Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:09 2019-07-31
 * @ Description：
 */
public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<Main2Bean> mList = new ArrayList<>();
    private Main2Adapter mMainAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initView();
        initData();
    }

    @Override
    protected void initView() {
        mRv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {

        for (int i = 0; i < 30; i++) {
            Main2Bean bean = new Main2Bean();
            bean.setName("lipc" + i);
            mList.add(bean);
        }

        mMainAdapter = new Main2Adapter(this, mList);
        mRv.setAdapter(mMainAdapter);
    }
}

package com.lpc.test.base;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.R;
import com.lpc.test.adapter.TextAdapter;
import com.lpc.test.bean.TextBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:49 2019-08-08
 * @ Description：只有textview的recyclerview
 */
public abstract class BaseTextRecyclerViewActivity extends BaseActivity {

    protected RecyclerView mRv;

    protected TextAdapter mAdapter;

    protected List<TextBean> mList = new ArrayList<>();

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void initView() {

        mRv = findViewById(R.id.rv);
        initRecyclerView(mRv);
    }

    @Override
    protected void initData() {
        initRecyclerViewData();

        mAdapter = new TextAdapter(this, mList);
        mRv.setAdapter(mAdapter);
    }

    /**
     * 初始化RecyclerView的数据
     */
    protected abstract void initRecyclerViewData();

    /**
     * RecyclerView的基本配置
     * @param recyclerView
     */
    protected void initRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * 添加RecyclerView的数据
     * @param name
     * @param onClickListener
     * @return
     */
    protected List<TextBean> addBeanToMList(String name, View.OnClickListener onClickListener) {
        TextBean bean = new TextBean();
        bean.setName(name);
        bean.setOnClickListener(onClickListener);
        mList.add(bean);
        return mList;
    }
}

package com.lpc.test.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.R;
import com.lpc.test.adapter.TitleContentAdapter;
import com.lpc.test.base.BaseActivity;
import com.lpc.test.bean.TitleContentBean;
import com.lpc.test.factory.MainBeanFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<TitleContentBean> mList = new ArrayList<>();
    private TitleContentAdapter mTitleContentAdapter;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_main;
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

        MainBeanFactory beanFactory = new MainBeanFactory();
        mList = beanFactory.getList(this);

        mTitleContentAdapter = new TitleContentAdapter(this, mList);
        mRv.setAdapter(mTitleContentAdapter);
    }
}

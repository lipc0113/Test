package com.lpc.test.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Trace;

import androidx.annotation.RequiresApi;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void initData() {

        Debug.startMethodTracing("TraceView");
//        Trace.beginSection("sysTrace");
        MainBeanFactory beanFactory = new MainBeanFactory();
        mList = beanFactory.getList(this);

        mTitleContentAdapter = new TitleContentAdapter(this, mList);
        mRv.setAdapter(mTitleContentAdapter);
//        Trace.endSection();
        Debug.stopMethodTracing();
    }
}

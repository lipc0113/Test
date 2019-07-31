package com.lpc.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpc.test.bean.MainBean;
import com.lpc.test.factory.MainBeanFactory;
import com.lpc.test.adapter.MainAdapter;
import com.lpc.test.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<MainBean> mList = new ArrayList<>();
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {

        MainBeanFactory beanFactory = new MainBeanFactory();
        mList = beanFactory.getList(this);

        mMainAdapter = new MainAdapter(this, mList);
        mRv.setAdapter(mMainAdapter);
    }

    private void initView() {
        mRv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
    }
}

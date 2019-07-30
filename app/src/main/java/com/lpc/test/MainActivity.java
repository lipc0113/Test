package com.lpc.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<Bean> mList = new ArrayList<>();
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {

        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addBean("通过uri跳转activity的数据解析", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, UriActivity.class);
                startActivity(i);
            }
        });
        mList = beanFactory.build();

        mMainAdapter = new MainAdapter(this, mList);
        mRv.setAdapter(mMainAdapter);
    }

    private void initView() {
        mRv = findViewById(R.id.rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRv.setLayoutManager(gridLayoutManager);
    }
}

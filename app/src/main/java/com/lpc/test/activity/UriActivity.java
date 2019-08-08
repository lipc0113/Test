package com.lpc.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:18 2019-07-29
 * @ Description：
 */
public class UriActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

        tv = findViewById(R.id.tv);
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        Uri data = intent.getData();
        String scheme = data.getScheme();
        String host = data.getHost();
        String path = data.getPath();
        String query = data.getQuery();

        tv.setText("scheme = " + scheme + ";host = " + host + ";path = "
                + path + ";query = " + query);
    }
}

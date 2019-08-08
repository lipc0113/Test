package com.lpc.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 11:02 2019-08-08
 * @ Description：
 */
public class ActivityTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("通过uri跳转activity的数据解析", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("com.lpc.test");
                i.setData(Uri.parse("lipc0113://com.lpc.test/act?id=1&name=lipc0113"));
                ActivityTestActivity.this.startActivity(i);
            }
        });
    }
}

package com.lpc.test.activity;

import android.content.Intent;
import android.view.View;

import com.lpc.test.activity.sub.ScrollTextViewActivity;
import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 11:02 2019-08-08
 * @ Description：
 */
public class TextViewTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("滚动的TextView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TextViewTestActivity.this, ScrollTextViewActivity.class);
                startActivity(i);
            }
        });
    }
}

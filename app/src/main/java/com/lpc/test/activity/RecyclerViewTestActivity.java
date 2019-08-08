package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:09 2019-07-31
 * @ Description：
 */
public class RecyclerViewTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("RecyclerView的优化", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

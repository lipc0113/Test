package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class AnnotationTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("泛型-上下边界", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

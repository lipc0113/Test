package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.Generator;
import com.lpc.test.utils.LogUtil;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class ReflectTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("泛型-上下边界", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

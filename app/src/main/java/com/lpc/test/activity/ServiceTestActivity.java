package com.lpc.test.activity;

import android.content.Intent;
import android.os.Build;
import android.view.View;

import com.lpc.test.service.TestService;
import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 11:02 2019-08-08
 * @ Description：
 */
public class ServiceTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("启动服务", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ServiceTestActivity.this, TestService.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(i);
                } else {
                    startService(i);
                }
            }
        });

        addBeanToMList("JobService服务-TODO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

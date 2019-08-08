package com.lpc.test;

import android.app.Application;

import com.lpc.test.utils.UIUtil;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:59 2019-08-07
 * @ Description：
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UIUtil.init(this);
    }
}

package com.lpc.test;

import android.app.Application;

import com.lpc.test.utils.CrashHandler;
import com.lpc.test.utils.FileUtils;
import com.lpc.test.utils.SkinUtil;
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

        if (!FileUtils.createOrExistsDir(Constants.BASE_ENVIRONMENT_FILE_PATH)) {
            return;
        }

        CrashHandler crashHandler = new CrashHandler();
        crashHandler.init();

        SkinUtil.init(this);
    }
}

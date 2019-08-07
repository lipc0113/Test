package com.lpc.test.utils;

import android.os.Handler;

import com.ultrapower.java.rcslib.RcsLib;

public class UIThreadUtil {

    // 判断当前线程是否运行在主线程内
    public static boolean isRunInUiThread() {

        return UIUtil.getMainThreadId() == android.os.Process.myTid();
    }

    // 封装UI操作维护在主线程里面
    public static void runInUiThread(Runnable runnable) {
        if (isRunInUiThread()) {
            runnable.run();
        } else {
            // 通过handler将当前任务传递到主线程中去做处理
            getMainHandler().post(runnable);
        }
    }

    // 封装UI操作维护在主线程里面
    public static void runInUiThreadDelay(Runnable runnable, long time) {

        // 通过handler将当前任务传递到主线程中去做处理
        getMainHandler().postDelayed(runnable, time);

    }

    //将此操作在主进程移除
    public static void removeInUiThread(Runnable runnable) {

        getMainHandler().removeCallbacks(runnable);
    }

    /**
     * 主线程handler
     *
     * @return
     */
    public static Handler getMainHandler() {

        return UIUtil.getMainHandler();
    }

}

package com.lpc.test.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/**
 * 功能:全局工具类
 * <p>
 * 描述:必须在主线程初始化
 * <p>
 * Created by lipc0113 on 2018/3/5.
 */

public class UIUtil {

    private static Context sContext;

    //主线程handler
    private static Handler mainHandler = new Handler();

    //获取主线程的id
    private static int mainThreadId = android.os.Process.myTid();

    public static Context getContext() {

        return sContext;
    }

    public static Handler getMainHandler() {
        return mainHandler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    /**
     * 得到版本号
     */
    public static int getVersion() {
        int version = 1;
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            version = info.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return version;
    }

    //activity跳转---action
    public static void startActivity(Activity activity, String action){

        Intent i = new Intent();
        i.setAction(action);
        if(activity.getPackageManager().resolveActivity(i
                , PackageManager.MATCH_DEFAULT_ONLY) != null){
            activity.startActivity(i);
        }else{
            ToastUtils.showShortToast("app中没有此页面");
        }
    }

    public static void startActivity(Context context, String action){

        Intent i = new Intent();
        i.setAction(action);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(context.getPackageManager().resolveActivity(i
                , PackageManager.MATCH_DEFAULT_ONLY) != null){
            context.startActivity(i);
        }else{
            ToastUtils.showShortToast("app中没有此页面");
        }
    }

    //activity跳转---intent
    public static void startActivity(Activity activity, Intent intent){

        if(activity.getPackageManager().resolveActivity(intent
                , PackageManager.MATCH_DEFAULT_ONLY) != null){
            activity.startActivity(intent);
        }else{
            ToastUtils.showShortToast("app中没有此页面");
        }
    }

    public static void startActivity(Context context, Intent intent){

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(context.getPackageManager().resolveActivity(intent
                , PackageManager.MATCH_DEFAULT_ONLY) != null){
            context.startActivity(intent);
        }else{
            ToastUtils.showShortToast("app中没有此页面");
        }
    }

    //加载图片
    public static Drawable getDrawable(int mTabBackgroundResId) {
        return getResource().getDrawable(mTabBackgroundResId);
    }

    // 获取资源文件夹的方法
    public static Resources getResource() {
        return getContext().getResources();
    }

    // 获取string操作
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    public static int getColor(int resId){
        return getResource().getColor(resId);
    }

    // 获取string数组操作
    public static String[] getStringArray(int resId) {
        return getResource().getStringArray(resId);
    }

    //包名
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static String getCurProcessName() {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) getContext()
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    public static void init(Context context){

        sContext = context;
    }
}

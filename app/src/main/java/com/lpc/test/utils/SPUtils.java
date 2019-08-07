package com.lpc.test.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by lipc0113 on 2017/12/18.
 */

public class SPUtils {

    private SPUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 保存在手机里面的文件名
     */
    public static final String SP_NAME = "RCS_DATA";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key
     * @param
     */
    public static void putString(String key, String s) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, s);
        editor.apply();
    }

    public static void putInt(String key, int i) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, i);
        editor.apply();
    }

    public static void putBoolean(String key, boolean b) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, b);
        editor.apply();
    }

    public static void putFloat(String key, float f) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, f);
        editor.apply();
    }

    public static void putLong(String key, long l) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, l);
        editor.apply();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key
     * @param
     * @return
     */
    public static String getString(String key, String defValue) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static int getInt(String key, int defValue) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static float getFloat(String key, float defValue) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getFloat(key, defValue);
    }

    public static long getLong(String key, long defValue) {

        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    public static void remove(String key) {
        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 清除所有数据
     */
    public static void clear() {
        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key
     * @return
     */
    public static boolean contains(String key) {
        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @return
     */
    public static Map<String, ?> getAll() {
        SharedPreferences sp = UIUtil.getContext().getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

}

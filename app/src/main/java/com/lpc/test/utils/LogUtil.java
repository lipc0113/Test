package com.lpc.test.utils;

import android.util.Log;


/**
 * 功能:
 * <p>
 * 描述: 正式Tag为class名称，lipc0113临时测试log
 * <p>
 * Created by lipc0113 on 2017/12/21.
 */

public class LogUtil {

    private static final String TAG = "lipc0113";

    private LogUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * show error note
     *
     * @param error
     */
    public static void e(String error) {

        Log.e(TAG, "---> " + error);
    }


    public static void e(String tag, String error) {
        Log.e(tag, "---> " + error);
    }

    public static void e(Throwable throwable) {

        if (throwable != null) {

            final StackTraceElement[] stackTrace = throwable.getStackTrace();
            final String message = throwable.getMessage();
            StringBuffer sb = new StringBuffer();
            sb.append("fatal :");
            sb.append(message);
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append(stackTrace[i]);
            }

            Log.e(TAG, "---> " + sb.toString());
        }
    }

    public static void e(String tag, Throwable ex) {

        if (ex != null) {

            final StackTraceElement[] stackTrace = ex.getStackTrace();
            final String message = ex.getMessage();
            StringBuffer sb = new StringBuffer();
            sb.append("fatal :");
            sb.append(message);
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append(stackTrace[i]);
            }

            Log.e(tag, "---> " + sb.toString());
        }
    }

    /**
     * show debug note
     *
     * @param infor
     */
    public static void d(String infor) {

        Log.d(TAG, "---> " + infor);
    }

    public static void d(String tag, String infor) {
        Log.d(tag, "---> " + infor);
    }

    public static void i(String infor) {

        Log.i(TAG, "---> " + infor);
    }

    public static void i(String tag, String infor) {
        Log.i(tag, "---> " + infor);
    }
}

package com.lpc.test.utils;


import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;


public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public void init() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        if (ex != null) {
            final StackTraceElement[] stackTrace = ex.getStackTrace();
            final String message = ex.getMessage();
            StringBuffer sb = new StringBuffer();
            sb.append("\n");
            sb.append(DateUtil.getDateString(DateUtil.NOW_TIME));
            sb.append("\n");
            sb.append(message);
            sb.append("\n");
            for (int i = 0; i < stackTrace.length; i++) {
                sb.append(stackTrace[i]);
            }
            LogUtil.e("Crash", sb.toString());
//            FileUtils.writeFileFromString(FileUtils.DISK_FILE, sb.toString(), true);

            exitApp();
        }

    }

    private void exitApp() {

        new Thread() {
            public void run() {

                Looper.prepare();
                Toast.makeText(UIUtil.getContext(), "很抱歉,程序出现异常,即将退出.", Toast.LENGTH_SHORT)
                        .show();
                Looper.loop();
            }
        }.start();

        SystemClock.sleep(1500);

        //重启操作：两次自启时间间隔<1分半将不自启
//        SharedPreferences sp = UIUtil.getContext().getSharedPreferences("launchTime", Context.MODE_PRIVATE);
//        long launchTime = sp.getLong("launchTime", 0L);
//        if (System.currentTimeMillis() - launchTime >= 90L * 1000L) {
//
//            sp.edit().putLong("launchTime", System.currentTimeMillis()).apply();
//
//            //自启设定，并关闭之前的进程
//            Intent i = UIUtil.getContext().getPackageManager().getLaunchIntentForPackage(
//                    UIUtil.getContext().getPackageName());
//            PendingIntent pendingIntent = PendingIntent.getActivity(UIUtil.getContext(),
//                    0, i, PendingIntent.FLAG_ONE_SHOT);
//            AlarmManager alarmManager = (AlarmManager) UIUtil.getContext()
//                    .getSystemService(Context.ALARM_SERVICE);
//            alarmManager.set(AlarmManager.RTC,
//                    System.currentTimeMillis() + 1000, pendingIntent);
//        }

        ActivityStackManager.getInstance().clearAllActivity();

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}

package com.lpc.test.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.lpc.test.R;
import com.lpc.test.utils.LogUtil;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:50 2020/4/26
 * @ Description：
 */
public class TestService extends Service {


    public static final String TAG = "TestService";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "oncreate");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForeground26();
        } else {
            Notification notification = new Notification();
            startForeground(R.string.app_name, notification);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.d(TAG, "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        LogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startForeground26() {
        String channelId = "Test";
        String channelName = "Test";
        NotificationChannel chan = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager == null) {
            return;
        }
        manager.createNotificationChannel(chan);
        Notification.Builder notificationBuilder = new Notification.Builder(this, channelId);
        Notification notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setContentTitle("Test")
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(R.string.app_name, notification);
        // 9.0车机必须5秒内notify出来，否则崩溃
        manager.notify(R.string.app_name, notification);
    }
}

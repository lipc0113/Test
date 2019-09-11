package com.lpc.test.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.lpc.test.annotation.Annotation;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.HandlerUtils;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.NetWorkUtil;
import com.lpc.test.utils.ToastUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 18:04 2019-08-08
 * @ Description：
 */
public class DuerOsTestActivity extends BaseTextRecyclerViewActivity implements HandlerUtils.OnHandleMessageListener {

    private HandlerUtils.HandlerHolder handlerHolder = new HandlerUtils.HandlerHolder(this);
    private MessageCallbackReceiver messageCallbackReceiver;

    @Override
    public void handlerMessage(Message msg) {

        switch (msg.what) {
            case Annotation.TYPE_ONE:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        messageCallbackReceiver = new MessageCallbackReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.baidu.duerosauto.app_controler.tts_callback");
        registerReceiver(messageCallbackReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (messageCallbackReceiver != null) {
            unregisterReceiver(messageCallbackReceiver);
        }
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("奇瑞t1c/m36t车型判断", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e(Build.ID.substring(0, 2));
            }
        });

        addBeanToMList("DuerOS消息回调", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts");
                i.putExtra("pkg_name", getPackageName());
                i.putExtra("tts_id", "123");
                i.putExtra("tts_text", "哈哈哈哈哈哈呵呵呵呵");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

    }

    class MessageCallbackReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            LogUtil.e(intent.toString());
            LogUtil.e("tts_id = " + intent.getStringExtra("tts_id"));
            LogUtil.e("tts_callback_status = " + intent.getStringExtra("tts_callback_status"));
        }
    }
}
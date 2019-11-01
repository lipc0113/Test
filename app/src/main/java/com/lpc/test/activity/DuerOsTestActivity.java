package com.lpc.test.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.view.View;

import com.lpc.test.annotation.Annotation;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.HandlerUtils;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.ToastUtils;

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

        addBeanToMList("确定多模操作", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.SURE");
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                i.setPackage("com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("取消多模操作", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.CANCEL");
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                i.setPackage("com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("来电广播", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.android.bdphone.open");
                i.setPackage("com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("挂断电话广播", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.android.bdphone.close");
                i.setPackage("com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("奇瑞t1c/m36t车型判断", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e(Build.ID.substring(0, 2));
                ToastUtils.showShortToast(Build.ID.substring(0, 2));
            }
        });

        addBeanToMList("DuerOS普通消息", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts");
                i.putExtra("pkg_name", getPackageName());
                i.putExtra("tts_text", "哈哈哈哈哈哈哈哈哈哈哈哈");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS回调消息", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts");
                i.putExtra("pkg_name", getPackageName());
                i.putExtra("tts_id", "123");
                i.putExtra("tts_text", "呵呵呵呵呵呵呵呵呵呵呵呵");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS长音效", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts");
                i.putExtra("tts_text", "long_audio");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS重度疲劳-0速度", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.WAKEUP");
                i.putExtra("action_type", 1);
                i.putExtra("speed", "0");
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS重度疲劳-80速度", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.WAKEUP");
                i.putExtra("action_type", 1);
                i.putExtra("speed", 80);
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS轻度疲劳", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.WAKEUP");
                i.putExtra("action_type", 2);
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("DuerOS中断疲劳预警", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.car.radio.WAKEUP");
                i.putExtra("action_type", 3);
                i.putExtra("action_pkg", "com.baidu.che.codriver");
                DuerOsTestActivity.this.sendBroadcast(i);
            }
        });

        addBeanToMList("关闭疲劳预警", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts_stop");
                i.putExtra("pkg_name", getPackageName());
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
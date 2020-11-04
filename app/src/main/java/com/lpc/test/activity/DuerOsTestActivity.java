package com.lpc.test.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.view.View;

import com.lpc.test.annotation.Annotation;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.HandlerUtils;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.ToastUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

        addBeanToMList("进入声纹页面", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClassName("com.baidu.che.codriver",
                        "com.baidu.che.codriver.ui.VrPrintRegisterActivity");
                i.putExtra("personCode", "123456");
                startActivity(i);
            }
        });

        addBeanToMList("进入测试页面", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClassName("com.baidu.che.codriver",
                        "com.baidu.che.codriver.ui.DevActivity");
                startActivity(i);
            }
        });

        addBeanToMList("进入声纹页面", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClassName("com.baidu.che.codriver",
                        "com.baidu.che.codriver.ui.VrPrintRegisterActivity");
                i.putExtra("personCode", "123123");
                startActivity(i);
            }
        });

        addBeanToMList("获取CUID", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File dir = new File(Environment.getExternalStorageDirectory() + "/wzm");
                //        创建文件夹
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String uuidFilePath = dir.getPath() + "/new_uuid.txt";
                if (!new File(uuidFilePath).exists()) {
                    LogUtil.e("loadUUIDFromFile not exist, uuidFilePath=" + uuidFilePath);
                }
                String loadId = readFile(uuidFilePath);
                LogUtil.e("loadUUIDFromFile uuidFilePath=" + uuidFilePath + ", loadId=" + loadId);
            }
        });

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

        addBeanToMList("DuerOS普通消息", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setAction("com.baidu.duerosauto.app_controler.tts");
                i.putExtra("pkg_name", getPackageName());
                i.putExtra("tts_text", "已为您切换为AR导航");
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

        // adb shell am broadcast -a com.baidu.duerosauto.app_controler.tts --es tts_text "long_audio"
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

        addBeanToMList("奇瑞t1c/m36t车型判断", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.i("Build.ID=" + Build.ID);
                ToastUtils.showShortToast("Build.ID=" + Build.ID);
                LogUtil.i("Build.MODEL=" + Build.MODEL);
                LogUtil.i("Build.BOARD=" + Build.BOARD);
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

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            FileInputStream fin = null;
            try {
                fin = new FileInputStream(fileName);
                int length = fin.available();
                byte[] buffer = new byte[length];
                fin.read(buffer);
                String res = new String(buffer, "UTF-8");
                fin.close();
                return res;
            } catch (Exception e) {
                LogUtil.e(e.getMessage());
            } finally {
                if (fin != null) {
                    try {
                        fin.close();
                    } catch (IOException e) {
                        LogUtil.e(e.getMessage());
                    }
                }
            }
        }
        return "";
    }
}
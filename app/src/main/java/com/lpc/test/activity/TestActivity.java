package com.lpc.test.activity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

import com.lpc.test.annotation.Annotation;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.HandlerUtils;
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
public class TestActivity extends BaseTextRecyclerViewActivity implements HandlerUtils.OnHandleMessageListener {

    private HandlerUtils.HandlerHolder handlerHolder = new HandlerUtils.HandlerHolder(this);

    @Override
    public void handlerMessage(Message msg) {

        switch (msg.what) {
            case Annotation.TYPE_ONE:
                ToastUtils.showShortToast((String) msg.obj);
                break;
            default:
                break;
        }
    }

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("Thread优先级", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                    }
                }).start();
            }
        });

        addBeanToMList("adb指令-后退", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Runtime.getRuntime().exec("input keyevent 4");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("判断网络类型", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String networkType = NetWorkUtil.getNetworkType();
                ToastUtils.showShortToast("networkType = " + networkType);
            }
        });

        addBeanToMList("ping指令", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
            }
        });

        addBeanToMList("CPU_ABI", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CPU_ABI = Build.CPU_ABI;
                ToastUtils.showShortToast("CPU_ABI = " + CPU_ABI);
            }
        });

    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {

            String line = null;
            try {
                Process pro = Runtime.getRuntime().exec("ping tts.baidu.com");
                BufferedReader buf = new BufferedReader(new InputStreamReader(
                        pro.getInputStream()));
                while ((line = buf.readLine()) != null) {

                    SystemClock.sleep(2000);
                    Message m = Message.obtain();
                    m.what = Annotation.TYPE_ONE;
                    m.obj = "INFO:" + line;
                    handlerHolder.sendMessage(m);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return 0;
        }
    }
}
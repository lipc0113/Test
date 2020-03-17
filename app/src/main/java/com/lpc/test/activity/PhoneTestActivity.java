package com.lpc.test.activity;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import com.lpc.test.annotation.Annotation;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.utils.HandlerUtils;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.NetWorkUtil;
import com.lpc.test.utils.ToastUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 18:04 2019-08-08
 * @ Description：
 */
public class PhoneTestActivity extends BaseTextRecyclerViewActivity implements HandlerUtils.OnHandleMessageListener {

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

        addBeanToMList("手机基本信息", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LogUtil.i("Build.ID=" + Build.ID);
                // 获取手机型号
                LogUtil.i("手机型号Build.MODEL=" + Build.MODEL);
                LogUtil.i("手机厂商Build.BOARD=" + Build.BOARD);
                LogUtil.i("系统版本号Build.VERSION.RELEASE=" + Build.VERSION.RELEASE);
                ToastUtils.showLongToast("Build.ID=" + Build.ID
                        + "；手机型号Build.MODEL=" + Build.MODEL
                        + "；手机厂商Build.BOARD=" + Build.BOARD
                        + "；系统版本号Build.VERSION.RELEASE=" + Build.VERSION.RELEASE);
            }
        });

        addBeanToMList("屏幕分辨率", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LogUtil.e("不可靠分辨率--------------------------------------------");
                DisplayMetrics dm = getResources().getDisplayMetrics();
                LogUtil.e("分辨率(宽): " + dm.widthPixels);
                LogUtil.e("分辨率(高): " + dm.heightPixels);
                LogUtil.e("xdpi: " + dm.xdpi);
                LogUtil.e("ydpi: " + dm.ydpi);
                LogUtil.e("densityDpi: " + dm.densityDpi);
                LogUtil.e("density: " + dm.density);

                Display defaultDisplay = getWindowManager().getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int x = point.x;
                int y = point.y;
                LogUtil.e("x = " + x + ",y = " + y);

                Rect outSize = new Rect();
                getWindowManager().getDefaultDisplay().getRectSize(outSize);
                int left = outSize.left;
                int top = outSize.top;
                int right = outSize.right;
                int bottom = outSize.bottom;
                LogUtil.e("left = " + left + ",top = " + top + ",right = " + right + ",bottom = " + bottom);

                DisplayMetrics outMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
                int widthPixels = outMetrics.widthPixels;
                int heightPixels = outMetrics.heightPixels;
                LogUtil.e("widthPixels = " + widthPixels + ",heightPixels = " + heightPixels);

                LogUtil.e("可靠分辨率--------------------------------------------");
                Point outSize2 = new Point();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    getWindowManager().getDefaultDisplay().getRealSize(outSize2);
                }
                int x2 = outSize2.x;
                int y2 = outSize2.y;
                LogUtil.e("x2 = " + x2 + ",y2 = " + y2);

                DisplayMetrics outMetrics2 = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    getWindowManager().getDefaultDisplay().getRealMetrics(outMetrics2);
                }
                int widthPixel = outMetrics2.widthPixels;
                int heightPixel = outMetrics2.heightPixels;
                int densityDpi = outMetrics2.densityDpi;
                float density = outMetrics2.density;
                LogUtil.e("widthPixel = " + widthPixel + ",heightPixel = " + heightPixel);
                LogUtil.e("densityDpi = " + densityDpi + ",density = " + density);
                ToastUtils.showLongToast("widthPixel = " + widthPixel
                        + ",heightPixel = " + heightPixel
                        + ";densityDpi = " + densityDpi + ",density = " + density);
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
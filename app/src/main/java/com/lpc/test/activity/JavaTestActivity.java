package com.lpc.test.activity;

import android.content.Intent;
import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.Child;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.ToastUtils;

import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class JavaTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("测量文件夹大小", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savePath = getExternalFilesDir("test").getPath();
                LogUtil.d("savePath=" + savePath);
                File file = new File(savePath);
                if (file != null && !file.exists()) {
                    file.mkdirs();
                }
                LogUtil.d("file.length()=" + file.length());
                LogUtil.d("file.getTotalSpace()=" + file.getTotalSpace());
                LogUtil.d("file.getUsableSpace()=" + file.getUsableSpace());
                LogUtil.d("file.getFreeSpace()=" + file.getFreeSpace());

                File file2 = new File(savePath + File.separator + "wifi_config.log");
                LogUtil.d("savePath2=" + savePath + File.separator + "wifi_config.log");
                if (file2 != null && !file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                LogUtil.d("file2.length()=" + file2.length());
                LogUtil.d("file2.getTotalSpace()=" + file2.getTotalSpace());
                LogUtil.d("file2.getUsableSpace()=" + file2.getUsableSpace());
                LogUtil.d("file2.getFreeSpace()=" + file2.getFreeSpace());
            }
        });

        addBeanToMList("用注释代替枚举", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTestActivity.this, AnnotationActivity.class);
                JavaTestActivity.this.startActivity(i);
            }
        });

        /**
         * 1.父类构造器执行的时候，子类成员变量还没有初始化
         * 2.父类构造器里，执行子类的方法时，假如new子类的成员变量，而子类成员变量又有初
         *  始化，子类的成员变量初始化会覆盖前者
         */
        addBeanToMList("父类构造器调用的抽象方法对子类的成员变量的影响", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Child child = new Child();
                ToastUtils.showShortToast(child.getStudents().get(0));
            }
        });
    }
}

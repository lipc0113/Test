package com.lpc.test.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.lpc.test.activity.sub.AnnotationActivity;
import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.Child;
import com.lpc.test.bean.Generator;
import com.lpc.test.utils.LogUtil;
import com.lpc.test.utils.ToastUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class JavaTestActivity extends BaseTextRecyclerViewActivity {

    private static final int i = 16;
    // 0x代表16进制，0b代表2进制。这里的j = 1*16+6 = 22;
    private static final int j = 0x16;

    private static final int m = 0x166;

    private String json;

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("泛型-上下边界", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Generator<Integer> gInteger = new Generator<Integer>(123);
                Generator<Number> gNumber = new Generator<Number>(456);

//                showKeyValue1(gInteger);
                showKeyValue1(gNumber);

                showKeyValue2(gInteger);
                showKeyValue2(gNumber);

                showKeyValue3(gInteger);
                showKeyValue3(gNumber);
            }
        });

        addBeanToMList("主线程不能抓住子线程的异常", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
//                            try {
                            int i = 1 / 0;
//                            } catch (Exception e) {
//                                LogUtil.d("子线程Exception");
//                                e.printStackTrace();
//                            }
                        }
                    }.start();
                } catch (Exception e) {
                    LogUtil.d("主线程Exception");
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("进制转换", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("Integer.toBinaryString(i) = " + Integer.toBinaryString(i));
                LogUtil.d("Integer.toHexString(i) = " + Integer.toHexString(i));
                LogUtil.d("Integer.toOctalString(i) = " + Integer.toOctalString(i));

                LogUtil.d("j = " + j);
                LogUtil.d("Integer.toBinaryString(j) = " + Integer.toBinaryString(j));
                LogUtil.d("Integer.toHexString(j) = " + Integer.toHexString(j));
                LogUtil.d("Integer.toOctalString(j) = " + Integer.toOctalString(j));

                LogUtil.d("m = " + m);
                LogUtil.d("Integer.toBinaryString(m) = " + Integer.toBinaryString(m));
                LogUtil.d("Integer.toHexString(m) = " + Integer.toHexString(m));
                LogUtil.d("Integer.toOctalString(m) = " + Integer.toOctalString(m));
            }
        });

        addBeanToMList("new File(null)", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = null;
                File file = new File(path); // 这里会直接报空指针
                LogUtil.d("file.getAbsolutePath()" + file.getAbsolutePath());
            }
        });

        addBeanToMList("用注释代替枚举", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTestActivity.this, AnnotationActivity.class);
                JavaTestActivity.this.startActivity(i);
            }
        });

        addBeanToMList("lists.remove()", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<String> lists = new ArrayList<>();
                        lists.add("123");
                        lists.add("456");
                        lists.add("789");
                        LogUtil.d("lists.remove(\"111\")" + lists.remove("111"));
                        LogUtil.d("lists.remove(null)" + lists.remove(null));
                        LogUtil.d("lists.remove(\"789\")" + lists.remove("789"));
                    }
                }
        );

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

        addBeanToMList("复杂集合转成json", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Map<String, List<String>> map = new HashMap<>();
                List<String> list = new ArrayList<>();
                list.add("lpc0113");
                list.add("syj0512");
                List<String> list2 = new ArrayList<>();
                list2.add("lpc0113");
                list2.add("syj0512");
                map.put("name", list);
                map.put("name2", list2);
                JSONObject object = new JSONObject(map);
                json = object.toString();
                LogUtil.d("json === " + json);
            }
        });

        addBeanToMList("json转成复杂集合", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(json)) {
                    try {
                        Map<String, List<String>> valueMap = new HashMap<>();
                        JSONObject jsonObject = new JSONObject(json);
                        Iterator<String> keyIter = jsonObject.keys();
                        String key;
                        Object value;
                        List<String> list = null;
                        JSONArray jsonArray = null;
                        while (keyIter.hasNext()) {
                            key = (String) keyIter.next();
                            value = jsonObject.get(key);
                            if (value != null) {
                                jsonArray = (JSONArray) value;
                                list = new ArrayList<>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    list.add((String) jsonArray.get(i));
                                }
                            }
                            valueMap.put(key, list);
                        }
                        LogUtil.d("valueMap === " + valueMap);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        addBeanToMList("生产者、消费者demo---TODO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2020/8/11
            }
        });

    }

    public void showKeyValue1(Generator<Number> obj) {
        LogUtil.d("泛型测试 key value is " + obj.getKey());
    }

    public void showKeyValue2(Generator<? extends Number> obj) {
        LogUtil.d("泛型测试2 key value is " + obj.getKey());
    }

    public <T extends Number> void showKeyValue3(Generator<T> obj) {
        LogUtil.d("泛型测试3 key value is " + obj.getKey());
    }
}

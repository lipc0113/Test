package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.GeneratorBean;
import com.lpc.test.utils.LogUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：1.getDeclaredField是可以获取一个类的所有字段.
 * getField只能获取类的public 字段.
 */
public class ReflectTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("Class", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                LogUtil.d("获取Class = " + bean.getClass().toString());

                try {
                    Class<?> aClass = Class.forName("com.lpc.test.bean.GeneratorBean");
                    LogUtil.d("获取Class2 = " + aClass.toString());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                LogUtil.d("获取Class的父类 = " + bean.getClass().getSuperclass().toString());
            }
        });

        addBeanToMList("Class的Constructor", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
                for (int i = 0; i < declaredConstructors.length; i++) {
                    LogUtil.d("遍历declaredConstructors = " + declaredConstructors[i].toString());
                }

                Constructor<? extends GeneratorBean> constructor = null;
                try {
                    constructor = aClass.getConstructor(Object.class, String.class);
                    constructor.setAccessible(true);
                    LogUtil.d("指定Constructor = " + constructor.toString());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                try {
                    GeneratorBean lipc = constructor.newInstance(1234, "lipc");
                    LogUtil.d("GeneratorBean = " + lipc.getId() + ";name = " + lipc.name);
                    // 子类也拥有父类private属性
                    LogUtil.d("GeneratorBean key = " + lipc.getKey());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("Class的Filed", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Field[] fields = aClass.getFields();
                for (int i = 0; i < fields.length; i++) {
                    LogUtil.d("遍历getFields = " + fields[i].toString());
                }

                Field[] fields2 = aClass.getDeclaredFields();
                for (int i = 0; i < fields2.length; i++) {
                    LogUtil.d("遍历getDeclaredFields = " + fields2[i].toString());
                }

                Field idField = null;
                try {
                    idField = aClass.getDeclaredField("id");
                    idField.setAccessible(true);
                    LogUtil.d("指定field = " + idField.toString());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                try {
                    LogUtil.d("设置前id = " + bean.getId());
                    idField.set(bean, 456);
                    LogUtil.d("设置后id = " + bean.getId());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("Class的Method", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Method[] declaredMethods = aClass.getDeclaredMethods();
                for (int i = 0; i < declaredMethods.length; i++) {
                    LogUtil.d("遍历declaredMethods = " + declaredMethods[i].toString());
                }

                Method declaredMethod = null;
                try {
                    declaredMethod = aClass.getDeclaredMethod("setId", int.class);
                    declaredMethod.setAccessible(true);
                    LogUtil.d("指定declaredMethod = " + declaredMethod.toString());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                try {
                    LogUtil.d("设置前id = " + bean.getId());
                    declaredMethod.invoke(bean, 678);
                    LogUtil.d("设置后id = " + bean.getId());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

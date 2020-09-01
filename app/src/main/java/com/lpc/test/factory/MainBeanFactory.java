package com.lpc.test.factory;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.lpc.test.activity.ActivityTestActivity;
import com.lpc.test.activity.AnimationTestActivity;
import com.lpc.test.activity.DuerOsTestActivity;
import com.lpc.test.activity.JavaTestActivity;
import com.lpc.test.activity.PhoneTestActivity;
import com.lpc.test.activity.RecyclerViewTestActivity;
import com.lpc.test.activity.ServiceTestActivity;
import com.lpc.test.activity.TestActivity;
import com.lpc.test.activity.TextViewTestActivity;
import com.lpc.test.activity.WebViewTestActivity;
import com.lpc.test.bean.TitleContentBean;
import com.lpc.test.kotlin_lib.KotlinActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:00 2019-07-29
 * @ Description：
 */
public class MainBeanFactory {

    private List<TitleContentBean> mList = new ArrayList<>();

    public List<TitleContentBean> getList(final Activity activity) {
        addBean("DuerOS", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, DuerOsTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Test", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, TestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Android", 0);
        addBean("Kotlin", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, KotlinActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Activity", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, ActivityTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Service", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, ServiceTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("RecyclerView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, RecyclerViewTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("TextView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, TextViewTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Phone", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, PhoneTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("WebView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, WebViewTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Animaition", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, AnimationTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("手写Handler---TODO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2020/8/11
            }
        });
        addBean("Java", 0);
        addBean("Java基本知识", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, JavaTestActivity.class);
                activity.startActivity(i);
            }
        });
        return mList;
    }

    private void addBean(String name, View.OnClickListener onClickListener) {
        TitleContentBean bean = new TitleContentBean();
        bean.setName(name);
        bean.setOnClickListener(onClickListener);
        mList.add(bean);
    }

    /**
     * 添加title类型item
     *
     * @param name
     * @param viewType
     */
    private void addBean(String name, int viewType) {
        TitleContentBean bean = new TitleContentBean();
        bean.setName(name);
        bean.setViewType(viewType);
        mList.add(bean);
    }
}

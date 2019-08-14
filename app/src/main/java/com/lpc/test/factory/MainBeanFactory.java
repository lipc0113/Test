package com.lpc.test.factory;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.lpc.test.activity.ActivityTestActivity;
import com.lpc.test.activity.JavaTestActivity;
import com.lpc.test.activity.RecyclerViewTestActivity;
import com.lpc.test.activity.TestActivity;
import com.lpc.test.activity.WebViewTestActivity;
import com.lpc.test.bean.TitleContentBean;

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
        addBean("Test", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, TestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Android", 0);
        addBean("Activity", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, ActivityTestActivity.class);
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
        addBean("WebView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, WebViewTestActivity.class);
                activity.startActivity(i);
            }
        });
        addBean("Java", new View.OnClickListener() {
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

package com.lpc.test.factory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.lpc.test.activity.RecyclerViewActivity;
import com.lpc.test.bean.MainBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:00 2019-07-29
 * @ Description：
 */
public class MainBeanFactory {

    private List<MainBean> mList = new ArrayList<>();

    public List<MainBean> getList(final Activity activity) {
        addBean("Activity", 0);
        addBean("通过uri跳转activity的数据解析", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("com.lpc.test");
                i.setData(Uri.parse("lipc0113://com.lpc.test/act?id=1&name=lipc0113"));
                activity.startActivity(i);
            }
        });
        addBean("RecyclerView", 0);
        addBean("RecyclerView的优化", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, RecyclerViewActivity.class);
                activity.startActivity(i);
            }
        });
//        addBean("Java", 0);
        addBean("用注释代替枚举", new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return mList;
    }

    private void addBean(String name, View.OnClickListener onClickListener) {
        MainBean bean = new MainBean();
        bean.setName(name);
        bean.setOnClickListener(onClickListener);
        mList.add(bean);
    }

    private void addBean(String name, int viewType) {
        MainBean bean = new MainBean();
        bean.setName(name);
        bean.setViewType(viewType);
        mList.add(bean);
    }
}

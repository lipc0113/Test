package com.lpc.test.factory;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.lpc.test.activity.MainActivity;
import com.lpc.test.activity.UriActivity;
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
        addBean("activity", 0);
        addBean("通过uri跳转activity的数据解析", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, UriActivity.class);
                activity.startActivity(i);
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

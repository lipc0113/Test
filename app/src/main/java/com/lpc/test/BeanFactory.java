package com.lpc.test;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:00 2019-07-29
 * @ Description：
 */
public class BeanFactory {

    private List<Bean> mList = new ArrayList<>();

    public void addBean(String name, View.OnClickListener onClickListener) {
        Bean bean = new Bean();
        bean.setName(name);
        bean.setOnClickListener(onClickListener);
        mList.add(bean);
    }

    public List<Bean> build() {
        return mList;
    }
}

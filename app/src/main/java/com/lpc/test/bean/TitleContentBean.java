package com.lpc.test.bean;

import android.view.View;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 16:54 2019-07-29
 * @ Description：
 */
public class TitleContentBean {

    private String name;

    private View.OnClickListener onClickListener;

    private int viewType = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}

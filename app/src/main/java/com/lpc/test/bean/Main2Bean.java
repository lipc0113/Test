package com.lpc.test.bean;

import android.view.View;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 16:54 2019-07-29
 * @ Description：
 */
public class Main2Bean {

    private String name;

    private View.OnClickListener onClickListener;

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

}

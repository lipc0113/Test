package com.lpc.test.activity;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:18 2019-07-29
 * @ Description：
 */
public class ScrollTextViewActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_scroll_text_view;
    }

    @Override
    protected void initView() {

        tv = findViewById(R.id.tv);
        tv.setText("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈呵" +
                "呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        tv.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void initData() {


    }
}

package com.lpc.test.activity.sub;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;
import com.lpc.test.widget.CircleProgressBar;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:18 2019-07-29
 * @ Description：圆形渐变色进度条
 */
public class CircleProgressBarActivity extends BaseActivity {

    private TextView tv;
    private CircleProgressBar progressBar;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_circle_progress_bar;
    }

    @Override
    protected void initView() {

        progressBar = findViewById(R.id.word_chain_end_center_circle);
        progressBar.setBackgroundColor(Color.parseColor("#1A000000"));
        progressBar.setColor(Color.parseColor("#FFFFFF"));
        progressBar.setProgressBarWidth(4);
        progressBar.setBackgroundProgressBarWidth(4);
    }

    @Override
    protected void initData() {

        progressBar.setProgress(20);
    }
}

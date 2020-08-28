package com.lpc.test.activity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class TransitionDrawableAnimationTestActivity extends BaseActivity {


    private ImageView iv;
    private TransitionDrawable drawable;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_animation_transition;
    }

    @Override
    protected void initView() {

        iv = findViewById(R.id.iv);
        drawable = (TransitionDrawable) iv.getDrawable();

    }

    @Override
    protected void initData() {
        drawable.startTransition(50_000);
    }
}

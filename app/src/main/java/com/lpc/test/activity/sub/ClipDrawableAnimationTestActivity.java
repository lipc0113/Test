package com.lpc.test.activity.sub;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：裁剪动画
 */
public class ClipDrawableAnimationTestActivity extends BaseActivity {


    private ImageView iv;
    private int level;
    private ClipDrawable drawable;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            level = level + 100;
            drawable.setLevel(level);
            handler.sendEmptyMessageDelayed(1001, 10);
        }
    };

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_animation_clip;
    }

    @Override
    protected void initView() {

        iv = findViewById(R.id.iv);
        drawable = (ClipDrawable) iv.getDrawable();
        drawable.setAlpha(150);
    }

    @Override
    protected void initData() {
        handler.sendEmptyMessage(1001);
    }
}

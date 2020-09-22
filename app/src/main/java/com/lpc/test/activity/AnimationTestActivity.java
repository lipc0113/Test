package com.lpc.test.activity;

import android.content.Intent;
import android.view.View;

import com.lpc.test.activity.sub.ClipDrawableAnimationTestActivity;
import com.lpc.test.activity.sub.TransitionDrawableAnimationTestActivity;
import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class AnimationTestActivity extends BaseTextRecyclerViewActivity {


    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("ClipDrawable", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AnimationTestActivity.this, ClipDrawableAnimationTestActivity.class);
                AnimationTestActivity.this.startActivity(i);
            }
        });

        addBeanToMList("TransitionDrawable", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AnimationTestActivity.this, TransitionDrawableAnimationTestActivity.class);
                AnimationTestActivity.this.startActivity(i);
            }
        });
    }
}

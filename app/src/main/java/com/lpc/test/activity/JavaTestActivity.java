package com.lpc.test.activity;

import android.content.Intent;
import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：
 */
public class JavaTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("用注释代替枚举", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JavaTestActivity.this, AnnotationActivity.class);
                JavaTestActivity.this.startActivity(i);
            }
        });
    }
}

package com.lpc.test.activity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.IntDef;

import com.lpc.test.R;
import com.lpc.test.base.BaseActivity;
import com.lpc.test.utils.LogUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:09 2019-08-01
 * @ Description：
 */
public class AnnotationActivity extends BaseActivity {

    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    @WeekDays
    private int mCurrentDay = SUNDAY;

    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface WeekDays {
    }

    private TextView tv;

    @Override
    protected int getContentViewResid() {
        return R.layout.activity_test;
    }

    @Override
    protected void initData() {
        setCurrentDay(SUNDAY);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(getmCurrentDay()));
            }
        });
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
    }

    public void setCurrentDay(@WeekDays int currentDay) {

        mCurrentDay = currentDay;
    }

    @WeekDays
    public int getmCurrentDay() {
        return mCurrentDay;
    }
}

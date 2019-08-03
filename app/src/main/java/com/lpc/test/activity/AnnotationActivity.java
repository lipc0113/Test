package com.lpc.test.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lpc.test.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:09 2019-08-01
 * @ Description：
 */
public class AnnotationActivity extends AppCompatActivity {

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
        initData();
    }

    private void initData() {
        setCurrentDay(SUNDAY);
    }

    private void initView() {
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

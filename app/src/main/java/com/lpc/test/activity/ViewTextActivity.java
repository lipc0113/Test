package com.lpc.test.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lpc.test.R;
import com.lpc.test.utils.LogUtil;

/**
 * 功能:
 * <p>
 * 描述:
 * <p>
 * Created by lipc0113 on 2021/3/7.
 */
public class ViewTextActivity extends AppCompatActivity {


    private TextView tvLocation;
    private TextView tvLocation2;
    private int scaledTouchSlop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initView();
        initData();
    }

    private void initView() {
        tvLocation = findViewById(R.id.tv_location);
        tvLocation2 = findViewById(R.id.tv_location2);
    }

    private void initData() {
        tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printlnLocation(v);
            }
        });
        tvLocation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printlnLocation(v);
            }
        });

        scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        // 改变layoutParams实现滑动
        tvLocation.setOnTouchListener(LayoutParamsTouchListener);
        // ScrollTo(绝对滑动)/ScrollBy(相对滑动)实现滑动
        tvLocation2.setOnTouchListener(ScrollToTouchListener);
        // TODO: 2021/3/7  通过动画实现滑动
    }

    public final View.OnTouchListener ScrollToTouchListener = new View.OnTouchListener() {
        private int mlastY;
        private int mlastX;

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mlastX = (int) event.getX();
                mlastY = (int) event.getY();
            }

            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                int scrollX = x - mlastX;
                int scrollY = y - mlastY;
                LogUtil.d("scrollX = " + scrollX);
                LogUtil.d("scrollY = " + scrollY);
                v.scrollBy(-scrollX, -scrollY);

                mlastX = x;
                mlastY = y;
                printlnLocation(v);
            }
            return false;
        }
    };

    private final View.OnTouchListener LayoutParamsTouchListener = new View.OnTouchListener() {
        ViewGroup.MarginLayoutParams layoutParams = null;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                layoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                if (Math.abs(event.getX()) > scaledTouchSlop || Math.abs(event.getY()) > scaledTouchSlop) {
                    LogUtil.d("event.getX() = " + event.getX());
                    LogUtil.d("event.getY() = " + event.getY());
                    layoutParams.leftMargin += (int) event.getX();
                    layoutParams.topMargin += (int) event.getY();
//                    v.setLayoutParams(layoutParams);
                    v.requestLayout();
                    printlnLocation(v);
                }
            }
            return false;
        }
    };

    private void printlnLocation(View v) {
        LogUtil.d("v.getLeft() = " + v.getLeft());
        LogUtil.d("v.getRight() = " + v.getRight());
        LogUtil.d("v.getTop() = " + v.getTop());
        LogUtil.d("v.getBottom() = " + v.getBottom());
        LogUtil.d("v.getX() = " + v.getX());
        LogUtil.d("v.getY() = " + v.getY());
        LogUtil.d("v.getTranslationX() = " + v.getTranslationX());
        LogUtil.d("v.getTranslationY() = " + v.getTranslationY());
    }


}

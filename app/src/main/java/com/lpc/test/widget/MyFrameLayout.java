package com.lpc.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lpc.test.utils.LogUtil;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:27 PM 2021/1/13
 * @ Description：
 */
public class MyFrameLayout extends FrameLayout {

    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            LogUtil.d("MotionEvent.ACTION_DOWN  MyFrameLayout");
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            LogUtil.d("MotionEvent.ACTION_MOVE  MyFrameLayout");
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            LogUtil.d("MotionEvent.ACTION_UP MyFrameLayout");
        }else if(event.getAction() == MotionEvent.ACTION_CANCEL){
            LogUtil.d("MotionEvent.ACTION_CANCEL  MyFrameLayout");
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        /** 子控件拦截ACTION_DOWN事件后，这里父控件拦截ACTION_MOVE、ACTION_UP事件后，
        * 子控件就只能收到ACTION_CANCEL事件了。而且父控件也不会执行后续的ACTION_MOVE、ACTION_UP事件
        */
//        if (ev.getAction() == MotionEvent.ACTION_UP) {
//            return true;
//        }
        return super.onInterceptTouchEvent(ev);
    }
}

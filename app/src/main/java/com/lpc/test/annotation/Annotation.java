package com.lpc.test.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 22:02 2019-08-08
 * @ Description：
 */
public class Annotation {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;
    public static final int TYPE_FOUR = 3;
    public static final int TYPE_FIVE = 4;
    public static final int TYPE_SIX = 5;
    public static final int TYPE_SEVEN = 6;

    @IntDef({TYPE_ONE, TYPE_TWO, TYPE_THREE, TYPE_FOUR, TYPE_FIVE, TYPE_SIX, TYPE_SEVEN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HandlerType {
    }
}

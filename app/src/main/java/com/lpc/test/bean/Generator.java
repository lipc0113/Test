package com.lpc.test.bean;

/**
 * 功能:
 * <p>
 * 描述:
 * <p>
 * Created by lipc0113 on 2021/1/21.
 */
public class Generator<T> {

    private T mI;

    public Generator(T i) {
        mI = i;
    }

    public String getKey(){
        return mI.toString();
    }
}

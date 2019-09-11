package com.lpc.test.bean;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:06 2019-09-11
 * @ Description：
 */
public abstract class Person {

    public Person() {
        parseParams();
    }

    protected abstract void parseParams();
}

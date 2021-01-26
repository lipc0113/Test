package com.lpc.test.bean;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:54 AM 2021/1/26
 * @ Description：
 */
public class GeneratorParentBean<T> {

    private T key;

    // 泛型构造方法形参key的类型也为T，T的类型由外部指定
    public GeneratorParentBean(T key) {
        this.key = key;
    }

    // 泛型方法getKey的返回值类型为T，T的类型由外部指定
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

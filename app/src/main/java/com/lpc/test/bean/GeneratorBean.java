package com.lpc.test.bean;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:54 AM 2021/1/26
 * @ Description：
 */
public class GeneratorBean<T> extends GeneratorParentBean<T> {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name;

    public GeneratorBean(T key) {
        super(key);
    }

    public GeneratorBean(T key, String name) {
        super(key);
        this.name = name;
    }
}

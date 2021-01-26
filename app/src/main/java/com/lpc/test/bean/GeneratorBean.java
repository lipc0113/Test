package com.lpc.test.bean;

import com.lpc.test.listener.TestListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:54 AM 2021/1/26
 * @ Description：
 */
public class GeneratorBean<T> extends GeneratorParentBean<T> implements TestListener<T> {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name;

    private List<String> mList = new ArrayList<>();
    private List<T> mList2 = new ArrayList<>();
    private List<String>[] strs = new List[10];

    public GeneratorBean(T key) {
        super(key);
    }

    public GeneratorBean(T key, String name) {
        super(key);
        this.name = name;
    }

    @Override
    public T test(T t) {
        return null;
    }
}

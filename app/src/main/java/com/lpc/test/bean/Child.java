package com.lpc.test.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:05 2019-09-11
 * @ Description：
 */
public class Child extends Person {

    private List<String> students;

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public Child() {
        super();
    }

    @Override
    protected void parseParams() {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add("123");
    }
}

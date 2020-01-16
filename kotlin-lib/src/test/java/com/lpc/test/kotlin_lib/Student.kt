package com.lpc.test.kotlin_lib

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:23 2020-01-16
 * @ Description：此kt文件由java文件转换而成
 */
class Student {
    var id = 0

    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (obj !is Student) {
            return false
        }
        return id == obj.id
    }

    override fun toString(): String {
        return super.toString()
    }
}
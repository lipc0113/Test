package com.lpc.test.kotlin_lib

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:21 2020-01-16
 * @ Description：
 */
class Person(val id: Int, var name: String) {

    val isLpc: Boolean
        get() = "lpc".equals(name)

    fun isFirst(): Boolean {
        return id == 1
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name')"
    }


}
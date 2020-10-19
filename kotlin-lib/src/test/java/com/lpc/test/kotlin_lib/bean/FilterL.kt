package com.lpc.test.kotlin_lib.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:05 2020/10/19
 * @ Description：
 */
class FilterL() : (String) -> Boolean {
    override fun invoke(p1: String): Boolean {
        return p1.startsWith("l")
    }
}
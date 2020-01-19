package com.lpc.test.kotlin_lib.interfaces

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:35 2020-01-19
 * @ Description：
 */
interface Clickable {
    fun onClick()
    fun onLongClick() = println("onLongClick")
}
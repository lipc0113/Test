package com.lpc.test.kotlin_lib.bean

import com.lpc.test.kotlin_lib.interfaces.Clickable
import com.lpc.test.kotlin_lib.interfaces.Clickable2

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:35 2020-01-19
 * @ Description：
 */
open class View : Clickable, Clickable2 {
    override fun onClick() {
        println("onClick")
    }

    override fun onLongClick() {
        super<Clickable2>.onLongClick()
    }

    protected fun printlnLog() = println("onClick-before")
}
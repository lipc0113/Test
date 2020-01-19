package com.lpc.test.kotlin_lib.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:35 2020-01-19
 * @ Description：
 */
class Button : View() {
    override fun onClick() {
        printlnLog()
        super.onClick()
        println("onClickButton")
    }

    override fun onLongClick() {
        println("onLongClickButton")
    }
}
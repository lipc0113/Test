package com.lpc.test.kotlin_lib.bean

import com.lpc.test.kotlin_lib.interfaces.Clickable

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:44 2020-01-20
 * @ Description：委托类
 */
class ButtonWrap(
        btn: Clickable = Button()
) : Clickable by btn {
    override fun onClick() {
        println("ClickButton:click")
    }
}
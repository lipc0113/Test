package com.lpc.test.kotlin_lib.bean

import com.lpc.test.kotlin_lib.interfaces.PlayInterface

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:23 2020-01-16
 * @ Description：此kt文件由java文件转换而成
 */
class Student(override var ball: String) : PlayInterface {
    override fun palyBall() {
        println("学生玩:${ball}")
    }
}
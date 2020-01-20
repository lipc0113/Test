package com.lpc.test.kotlin_lib.bean

import com.lpc.test.kotlin_lib.interfaces.PlayInterface

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 13:02 2020-01-20
 * @ Description：
 */
class ChildrenUser : User3, PlayInterface {

    constructor(id: Int) : this(id, "lpc")

    constructor(id: Int, name: String) : super(id, name)

    override var ball: String = "篮球"
        get() = "${field}等运动"
        set(value) {
            field = "${value}、羽毛球"
        }

    override fun palyBall() {
        println("孩子玩：${ball}")
    }

    override fun toString(): String {
        return "id=${id},name=${name}"
    }
}
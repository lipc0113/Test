package com.lpc.test.kotlin_lib.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:57 2020-01-19
 * @ Description：
 */
class Out {

    var id: Int = 101
    var name: String = "lpc"

    // inner代表内部类，可以拿到外部类的引用
    inner class Inner {
        fun println2() = println("${id} ${name}")
    }

    class Inner2 {
        fun println2() = println("哈哈")
    }
}
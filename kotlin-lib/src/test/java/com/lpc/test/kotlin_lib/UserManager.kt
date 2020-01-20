package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.bean.User5

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:31 2020-01-20
 * @ Description：
 */
object UserManager {
    val mList = arrayListOf<User5>()

    fun size() = mList.size

    fun println() {
        for (u in mList) {
            println(u)
        }
    }
}
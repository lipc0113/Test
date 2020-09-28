package com.lpc.test.kotlin_lib.test.topfun

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:57 2020-01-19
 * @ Description：
 */
val String.lengthIsEven: Boolean
    get() = this.length % 2 == 0

fun subHalf(str:String) = str.substring( str.length / 2)
fun String.lastChar2() = get(length - 1)
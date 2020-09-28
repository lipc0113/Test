package com.lpc.test.kotlin_lib.test.topfun


/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:57 2020-01-19
 * @ Description：
 */
fun <T> listOf2(vararg i: T): List<T> {
    val arrayList = arrayListOf<T>()
    for (t in i) {
        arrayList.add(t)
    }
    return arrayList
}

infix fun Any.to2(other: Any): Pair<Any, Any> {
    return Pair(this, other)
}
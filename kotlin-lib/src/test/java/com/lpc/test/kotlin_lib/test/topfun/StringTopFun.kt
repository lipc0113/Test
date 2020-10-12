package com.lpc.test.kotlin_lib.test.topfun

import java.util.concurrent.locks.Lock

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:57 2020-01-19
 * @ Description：
 */
fun <T> synchronized2(lock: Lock, action: () -> T): T {
    try {
        lock.lock()
        println("内联函数")
        return action()
    } catch (e: Exception) {
        throw Exception("Exception")
    } finally {
        lock.unlock()
    }
}

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    try {
        lock.lock()
        println("内联函数")
        return action()
    } catch (e: Exception) {
        throw Exception("Exception")
    } finally {
        lock.unlock()
    }
}

fun String.filterCustom4(filter: ((Char) -> Boolean)?) {
    // 第一种方式：判断filter是否为空
    if (filter == null) {
        println("filterCustom4：：函数类型的参数为空")
        return
    }
    val toCharArray = this.toCharArray()
    for (char in toCharArray) {
        if (filter(char)) {
            println("filterCustom4：：包含目标字符“${char}”")
            return
        }
        println("filterCustom4：：没有目标字符")
    }
}

fun String.filterCustom3(filter: ((Char) -> Boolean)?) {
    val toCharArray = this.toCharArray()
    for (char in toCharArray) {
        // 第二种方式：利用invoke方法，使用安全调用
        val b = filter?.invoke(char) ?: false
        if (b) {
            println("filterCustom3：：包含目标字符“${char}”")
            return
        }
    }
    println("filterCustom3：：没有目标字符")
}

fun String.filterCustom2(filter: (Char) -> Boolean = { it == 'l' }) {
    val toCharArray = this.toCharArray()
    for (char in toCharArray) {
        if (filter(char)) {
            println("filterCustom2：：包含目标字符“${char}”")
            return
        }
    }
    println("filterCustom2：：没有目标字符")
}

fun String.filterCustom(filter: (Char) -> Boolean) {
    val toCharArray = this.toCharArray()
    for (char in toCharArray) {
        if (filter(char)) {
            println("filterCustom::包含目标字符“${char}”")
            return
        }
    }
    println("filterCustom::没有目标字符")
}

val String.lengthIsEven: Boolean
    get() = this.length % 2 == 0

fun subHalf(str: String) = str.substring(str.length / 2)
fun String.lastChar2() = get(length - 1)


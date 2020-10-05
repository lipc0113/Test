package com.lpc.test.kotlin_lib.bean

/**
 * plusAssign +=
 * */
class Point2(var x: Int, var y: Int) {

    operator fun get(i: Int): Int {
        return when (i) {
            0 -> x
            1 -> y
            else -> throw RuntimeException("不支持这个数字")
        }
    }

    operator fun set(index: Int, i: Int) {
        return when (index) {
            0 -> x = i
            1 -> y = i
            else -> throw RuntimeException("不支持这个数字")
        }
    }

    operator fun plusAssign(other: Point2) {
        // 这里可以不做赋值操作
        this.x + other.x
        this.y += other.y
    }

    override fun toString(): String {
        return "x = " + x + ";y = " + y
    }
}
package com.lpc.test.kotlin_lib

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:46 2020-01-16
 * @ Description：
 */
enum class Color {
    RED, Blue, Green
}

enum class Color2(val r: Int, val b: Int, val g: Int) {
    RED(255, 0, 0), Blue(0, 0, 255), Green(0, 255, 0);
    fun rgb() = (r * 256 + g) * 256 + b
}
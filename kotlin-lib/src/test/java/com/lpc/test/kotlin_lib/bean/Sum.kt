package com.lpc.test.kotlin_lib.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 14:35 2020-01-19
 * @ Description：
 */
sealed class Expr {
    class Sum : Expr()
    class Num : Expr()
}
package com.lpc.test.kotlin_lib.test.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 9:50 AM 2020/11/4
 * @ Description：
 */
data class BinaryTreeNode<T>(var value: T) {
    var left: BinaryTreeNode<T>? = null
    var right: BinaryTreeNode<T>? = null
}
package com.lpc.test.kotlin_lib.test.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:57 2020/10/20
 * @ Description：
 */
class TreeNode(val value: Char) {

    val children = hashMapOf<Char, TreeNode>()
    var isEnd = false

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TreeNode

        return value == other.value
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + children.hashCode()
        return result
    }


}
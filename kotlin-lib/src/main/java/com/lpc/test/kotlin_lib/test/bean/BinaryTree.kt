package com.lpc.test.kotlin_lib.test.bean

import com.lpc.test.kotlin_lib.test.utils.LogUtil
import java.util.*

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 9:50 AM 2020/11/4
 * @ Description：
 */
class BinaryTree<T> {

    fun createBinaryPre(linkedList: LinkedList<T>): BinaryTreeNode<T>? {
        if (linkedList.size <= 0) {
            return null
        }
        val value = linkedList.removeFirst() ?: return null
        val root = BinaryTreeNode(value)
        if(root != null){
            root!!.left = createBinaryPre(linkedList)
            root!!.right = createBinaryPre(linkedList)
        }

        return root
    }

    fun printBinaryTreePreRecur(root: BinaryTreeNode<T>?) {
        if (root != null) {
            LogUtil.d("root.value = ${root.value}")
            printBinaryTreePreRecur(root.left)
            printBinaryTreePreRecur(root.right)
        }
    }
}

data class BinaryTreeNode<T>(var value: T) {
    var left: BinaryTreeNode<T>? = null
    var right: BinaryTreeNode<T>? = null
}
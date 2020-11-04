package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.bean.BinaryTree
import com.lpc.test.kotlin_lib.test.bean.BinaryTreeNode
import com.lpc.test.kotlin_lib.test.bean.ListNode
import com.lpc.test.kotlin_lib.test.utils.LogUtil
import java.util.*

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 19:43 2020/10/19
 * @ Description：数据结构与算法
 *
 *            A
 *       B         C
 *    D     E   F     G
 *  H   I        J
 */
class DataStructureActivity : AppCompatActivity() {

    val linkedList = LinkedList<String?>()
    var root: BinaryTreeNode<String?>? = null
    var binaryTree: BinaryTree<String?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_structure)
        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {
        linkedList.add("A")
        linkedList.add("B")
        linkedList.add("D")
        linkedList.add("H")
        linkedList.add(null)
        linkedList.add("I")
        linkedList.add(null)
        linkedList.add("E")
        linkedList.add(null)
        linkedList.add(null)
        linkedList.add("C")
        linkedList.add("F")
        linkedList.add(null)
        linkedList.add("J")
        linkedList.add(null)
        linkedList.add("G")
        linkedList.add(null)
        linkedList.add(null)

        binaryTree = BinaryTree()
    }

    fun 单链表反转(view: View) {
        val node = ListNode(10)
        val node2 = ListNode(20)
        val node3 = ListNode(30)
        val node4 = ListNode(40)
        node.next = node2
        node2.next = node3
        node3.next = node4
        var sort = sort(node)
        while (sort != null) {
            LogUtil.d("node = ${sort.value}")
            sort = sort.next
        }
    }

    fun sort(node10: ListNode?): ListNode? {

        var pre: ListNode? = null
        var current: ListNode? = node10
        var next: ListNode? = null

        if (current == null || current.next == null) {
            return current
        }

        while (current != null) {
            next = current?.next
            current.next = pre

            pre = current
            current = next
        }
        return pre
    }

    fun 先序创建二叉树(view: View) {
        root = binaryTree?.createBinaryPre(linkedList)
        LogUtil.d("root = $root")
    }


    fun 先序遍历二叉树_递归(view: View) {
        binaryTree?.printBinaryTreePreRecur(root)
    }

    fun 中序遍历二叉树_递归(view: View) {}
    fun 后序遍历二叉树_递归(view: View) {}
    fun 先序遍历二叉树_非递归(view: View) {}
    fun 中序遍历二叉树_非递归(view: View) {}
    fun 后序遍历二叉树_非递归(view: View) {}
    fun 广度优先bfs遍历二叉树_非递归(view: View) {}
    fun 广度优先bfs遍历二叉树_递归(view: View) {}
}
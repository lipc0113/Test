package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.view.View
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.bean.BinaryTreeNode
import com.lpc.test.kotlin_lib.test.bean.ListNode
import com.lpc.test.kotlin_lib.test.utils.LogUtil
import java.util.*
import kotlin.collections.HashMap

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
        linkedList.add(null)
        linkedList.add("I")
        linkedList.add(null)
        linkedList.add(null)
        linkedList.add("E")
        linkedList.add(null)
        linkedList.add(null)
        linkedList.add("C")
        linkedList.add("F")
        linkedList.add(null)
        linkedList.add("J")
        linkedList.add(null)
        linkedList.add(null)
        linkedList.add("G")
        linkedList.add(null)
        linkedList.add(null)
    }

    fun 单链表反转(view: View) {
        val node = ListNode(10)
        val node2 = ListNode(20)
        val node3 = ListNode(30)
        val node4 = ListNode(40)
        node.next = node2
        node2.next = node3
        node3.next = node4
        var sort = sort2(node)
        while (sort != null) {
            LogUtil.d("node = ${sort.value}")
            sort = sort.next
        }
    }

    fun sort2(node10: ListNode?): ListNode? {
        var pre: ListNode? = null
        var current = node10
        var next: ListNode? = null
        while (current != null) {
            next = current?.next
            current.next = pre
            pre = current
            current = next
        }
        return pre
    }

    fun 先序创建二叉树(view: View) {
        root = createBinaryPre(linkedList)
        LogUtil.d("root = $root")
    }

    fun 先序遍历二叉树_递归(view: View) {
        printBinaryTreePreRecur(root)
    }

    fun 中序遍历二叉树_递归(view: View) {
        printBinaryTreeMidRecur(root)
    }

    fun 后序遍历二叉树_递归(view: View) {
        printBinaryTreeBackRecur(root)
    }

    // TODO: 2020/11/4
    fun 先序遍历二叉树_非递归(view: View) {
        printBinaryTreePreNotRecur(root)
    }

    // TODO: 2020/11/4
    fun 中序遍历二叉树_非递归(view: View) {
        printBinaryTreeMidNotRecur(root)
    }

    // TODO: 2020/11/4
    fun 后序遍历二叉树_非递归(view: View) {
        printBinaryTreeBackNotRecur(root)
    }

    // TODO: 2020/11/4
    fun 广度优先bfs遍历二叉树_非递归(view: View) {
        val stack = LinkedList<BinaryTreeNode<String?>?>()
        stack.push(root)
        while (!stack.isEmpty()) {
            val node = stack.removeFirst() ?: continue
            LogUtil.d("root.value = ${node?.value}")
            if (node.left != null) {
                stack.addLast(node.left)
            }
            if (node.right != null) {
                stack.addLast(node.right)
            }
        }
    }

    private fun <T> createBinaryPre(linkedList: LinkedList<T>): BinaryTreeNode<T>? {
        if (linkedList.size <= 0) {
            return null
        }
        val value = linkedList.removeFirst() ?: return null
        val root = BinaryTreeNode(value)
        root.left = createBinaryPre(linkedList)
        root.right = createBinaryPre(linkedList)

        return root
    }

    private fun <T> printBinaryTreePreRecur(root: BinaryTreeNode<T>?) {
        if (root != null) {
            LogUtil.d("root.value = ${root.value}")
            printBinaryTreePreRecur(root.left)
            printBinaryTreePreRecur(root.right)
        }
    }

    private fun <T> printBinaryTreeMidRecur(root: BinaryTreeNode<T>?) {
        if (root != null) {
            printBinaryTreeMidRecur(root.left)
            LogUtil.d("root.value = ${root.value}")
            printBinaryTreeMidRecur(root.right)
        }
    }

    private fun <T> printBinaryTreeBackRecur(root: BinaryTreeNode<T>?) {
        if (root != null) {
            printBinaryTreeBackRecur(root.left)
            printBinaryTreeBackRecur(root.right)
            LogUtil.d("root.value = ${root.value}")
        }
    }

    private fun <T> printBinaryTreePreNotRecur(root: BinaryTreeNode<T>?) {
        val stack = Stack<BinaryTreeNode<T>>()
        var temp: BinaryTreeNode<T>?= root
        while (stack.size > 0 || temp != null) {
            if (temp != null) {
                LogUtil.d("temp = $temp")
                stack.push(temp)
                temp = temp?.left
            } else {
                temp = stack.pop()
                temp = temp?.right
            }
        }

    }

    private fun <T> printBinaryTreeMidNotRecur(root: BinaryTreeNode<T>?) {
        val stack = Stack<BinaryTreeNode<T>>()
        var temp = root
        while (stack.size > 0 || temp != null) {
            if (temp != null) {
                stack.push(temp)
                temp = temp.left
            } else {
                temp = stack.pop()
                LogUtil.d("temp = $temp")
                temp = temp?.right
            }
        }
    }

    private fun <T> printBinaryTreeBackNotRecur(root: BinaryTreeNode<T>?) {
        val stack = Stack<BinaryTreeNode<T>>()
        val map = HashMap<BinaryTreeNode<T>, Int>()
        var temp = root
        while (stack.size > 0 || temp != null) {
            if (temp != null) {
                stack.push(temp)
                map.put(temp, 1)
                temp = temp.left
            } else {
                temp = stack.peek()
                if (map.get(temp) == 2) {
                    temp = stack.pop()
                    LogUtil.d("temp = $temp")
                    temp = null
                } else {
                    map.put(temp, 2)
                    temp = temp?.right
                }
            }
        }
    }
}
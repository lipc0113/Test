package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.bean.ListNode
import com.lpc.test.kotlin_lib.test.utils.LogUtil

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 19:43 2020/10/19
 * @ Description：数据结构与算法
 */
class AlgorithmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)
        initView()
        initData()
    }

    private fun initView() {

    }

    private fun initData() {

    }

    fun test(view: View) {
        val node = ListNode(10)
        val node2 = ListNode(20)
        val node3 = ListNode(30)
        val node4 = ListNode(40)
        node.next = node2
        node2.next = node3
        node3.next = node4
        var sort = sort(node)
        while (sort != null) {
            println("node = ${sort.value}")
            sort = sort.next
        }
    }

    fun sort(node10: ListNode?) :ListNode?{

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
}
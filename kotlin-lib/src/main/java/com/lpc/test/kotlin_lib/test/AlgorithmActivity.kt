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
        val nums = intArrayOf(0, 2, 7, 11, 15)
        val target = 9
        val test = twoSum(nums, target)
        LogUtil.d("twoSum(nums, target) = ${test[0]},${test[1]}")
    }

    fun test2(view: View) {
        val node = ListNode(2)
        val node2 = ListNode(4)
        val node3 = ListNode(3)
        node.next = node2
        node2.next = node3
        val node4 = ListNode(5)
        val node5 = ListNode(6)
        val node6 = ListNode(4)
        node4.next = node5
        node5.next = node6
        val test2 = addTwoNumbers(node, node4)
        LogUtil.d("addTwoNumbers(node, node4) = ${test2?.value}")
        LogUtil.d("addTwoNumbers(node, node4) = ${test2?.next?.value}")
        LogUtil.d("addTwoNumbers(node, node4) = ${test2?.next?.next?.value}")
    }

    fun test3(view: View) {

    }

    /**
     * 两数之和
     *
     * nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * */
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val mutableMapOf = mutableMapOf<Int, Int>()
        for ((index, element) in nums.withIndex()) {
            if (mutableMapOf.containsKey(target - element)) {
                return intArrayOf(mutableMapOf[target - element]!!, index)
            } else {
                mutableMapOf[element] = index
            }
        }
        return intArrayOf(0, 0)
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * */
    fun addTwoNumbers(l11: ListNode?, l22: ListNode?): ListNode? {

        var l1 = l11
        var l2 = l22
        var head: ListNode? = null
        var tail: ListNode? = null
        var carry: Int = 0
        var listNode: ListNode? = null
        while (l1 != null || l2 != null) {
            var value:Int = ((l1?.value ?: 0) + (l2?.value ?: 0) + carry) % 10
            listNode = ListNode(value)
            if (head == null) {
                head = listNode
                tail = listNode
            } else {
                tail!!.next = listNode
                tail = tail.next
            }
            carry = ((l1?.value ?: 0) + (l2?.value ?: 0) + carry) / 10
            l1 = l1?.next
            l2 = l2?.next
        }
        if(carry != 0){
            listNode = ListNode(carry)
            tail!!.next = listNode
        }
        return head
    }

    fun lengthOfLongestSubstring(s: String): Int {

        return 0
    }
}
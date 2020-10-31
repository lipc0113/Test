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

    /**
     * 先找小
     */
    fun 冒泡排序(view: View) {
        val arrays = intArrayOf(10, 1, 4, 5, 0, 9, 2, 3)

        var temp = 0
        var b = false
        for (i in 0 until arrays.size - 1) {
            b = false
            for (j in arrays.size - 1 downTo i + 1) {
                if (arrays[j] < arrays[j - 1]) {
                    b = true
                    temp = arrays[j]
                    arrays[j] = arrays[j - 1]
                    arrays[j - 1] = temp
                }
            }
            if (!b) {
                break
            }
        }
        for (i in arrays.indices) {
            LogUtil.d("arrays[i] = ${arrays[i]}")
        }
    }

    /**
     * 先找大
     */
    fun 冒泡排序2(view: View) {
        val arrays = intArrayOf(10, 1, 4, 5, 0, 9, 2, 3)

        var temp = 0
        var b = false
        for (i in 0 until arrays.size - 1) {
            b = false
            for (j in 0 until arrays.size - 1 - i) {
                if (arrays[j] > arrays[j + 1]) {
                    b = true
                    temp = arrays[j]
                    arrays[j] = arrays[j + 1]
                    arrays[j + 1] = temp
                }
            }
            if (!b) {
                break
            }
        }
        for (i in arrays.indices) {
            LogUtil.d("arrays[i] = ${arrays[i]}")
        }
    }

    fun 选择排序(view: View) {
        val arrays = intArrayOf(10, 1, 4, 5, 0, 9, 2, 3)

        var temp = 0
        val min = 0
        var b = false
        for (i in 0 until arrays.size - 1) {
            b = false
            for (j in i + 1 until arrays.size) {
                if (arrays[j] < arrays[i]) {
                    b = true
                    temp = arrays[j]
                    arrays[j] = arrays[i]
                    arrays[i] = temp
                }
            }
            if (!b) {
                break
            }
        }
        for (i in arrays.indices) {
            LogUtil.d("arrays[i] = ${arrays[i]}")
        }
    }

    /**
     * 选择排序--优化
     */
    fun 选择排序2(view: View) {
        val arrays = intArrayOf(10, 1, 4, 5, 0, 9, 2, 3)

        var temp = 0
        var min = 0
        for (i in 0 until arrays.size - 1) {
            min = i
            for (j in i + 1 until arrays.size) {
                if (arrays[j] < arrays[min]) {
                    min = j
                }
            }
            temp = arrays[min]
            arrays[min] = arrays[i]
            arrays[i] = temp
        }
        for (i in arrays.indices) {
            LogUtil.d("arrays[i] = ${arrays[i]}")
        }
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

    fun 插入排序(view: View) {
        val arrays = intArrayOf(10, 1, 4, 5, 0, 9, 2, 3)

        var temp = 0
        var pre = 0
        var value = 0
        for (i in 1 until arrays.size) {
            pre = i - 1
            value = arrays[i]

            while (pre >= 0 && value < arrays[pre]) {
                arrays[pre + 1] = arrays[pre]
                pre--
            }
            arrays[pre + 1] = value
        }
        for (i in arrays.indices) {
            LogUtil.d("arrays[i] = ${arrays[i]}")
        }
    }

    /**
     * 左右指针
     * */
    fun 快速排序(view: View) {
        val array = arrayOf(4, 1, 7, 6, 9, 2, 8, 0, 3, 5)
        quickSort(array, 0, array.size - 1, ::partSort)
        for (i in array.indices) {
            LogUtil.d(array[i].toString())
        }
    }

    /**
     * 挖坑法
     * */
    fun 快速排序2(view: View) {
        val array = arrayOf(4, 1, 7, 6, 9, 2, 8, 0, 3, 5)
        quickSort(array, 0, array.size - 1, ::partSort2)
        for (i in array.indices) {
            LogUtil.d(array[i].toString())
        }
    }

    /**
     * 前后指针
     * */
    fun 快速排序3(view: View) {
        val array = arrayOf(4, 1, 7, 6, 9, 2, 8, 0, 3, 5)
        quickSort(array, 0, array.size - 1, ::partSort3)
        for (i in array.indices) {
            LogUtil.d(array[i].toString())
        }
    }


    /**
     * 非递归
     * */
    fun 快速排序4(view: View) {
        val array = arrayOf(4, 1, 7, 6, 9, 2, 8, 0, 3, 5)

    }

    private fun quickSort(array: Array<Int>, left: Int, right: Int, action: (Array<Int>, Int, Int) -> Int) {
        if (left >= right) {
            return
        }
        val index = action(array, left, right)
        quickSort(array, left, index - 1, action)
        quickSort(array, index + 1, right, action)
    }

    private fun partSort(array: Array<Int>, start: Int, end: Int): Int {
        var left = start
        var right = end
        var key = array[end]
        while (left < right) {
            while (array[left] < key && left < right) {
                left++
            }
            while (array[right] >= key && left < right) {
                right--
            }
            swap(array, left, right)
        }
        swap(array, left, end)
        return left
    }

    private fun partSort2(array: Array<Int>, start: Int, end: Int): Int {
        var left = start
        var right = end
        var key = array[end]
        while (left < right) {
            while (array[left] < key && left < right) {
                left++
            }
            array[right] = array[left]
            while (array[right] >= key && left < right) {
                right--
            }
            array[left] = array[right]
        }
        array[right] = key
        return left
    }

    private fun partSort3(array: Array<Int>, start: Int, end: Int): Int {
        var current = start
        var key = array[end]
        var pre = current - 1
        while (current < end) {
            while (array[current] < key && ++pre != current) {
                swap(array, pre, current)
//                swap(array[pre], array[current])
//                var temp = array[pre]
//                array[pre] = array[current]
//                array[current] = temp
            }
            current++
        }
        swap(array, ++pre, end)
//        swap(array[++pre], array[end])
//        var temp = array[++pre]
//        array[pre] = array[end]
//        array[end] = temp
        return pre
    }

    private fun swap(array: Array<Int>, i: Int, j: Int) {
        var temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}
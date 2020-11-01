package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.bean.ListNode
import com.lpc.test.kotlin_lib.test.bean.TreeNode
import com.lpc.test.kotlin_lib.test.utils.LogUtil

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 19:43 2020/10/19
 * @ Description：数据结构与算法
 */
class LeetCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leetcode)
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

    /**
     * 利用taget-index上的值，来求解
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

    /**
     * 考虑进位的问题
     *
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
            var value: Int = ((l1?.value ?: 0) + (l2?.value ?: 0) + carry) % 10
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
        if (carry != 0) {
            listNode = ListNode(carry)
            tail!!.next = listNode
        }
        return head
    }

    fun test3(view: View) {
        LogUtil.d("lengthOfLongestSubstring(\"abcabcbb\") = ${lengthOfLongestSubstring("abcabcbb")}")
    }

    /**
     * 滑动窗口
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val hashSetOf = hashSetOf<Char>()
        var right = 0
        val length = s.length
        val toCharArray = s.toCharArray()
        for ((index, value) in toCharArray.withIndex()) {
            if (index != 0) {
                hashSetOf.remove(s.get(index - 1))
            }
            while (right < length && !hashSetOf.contains(s.get(right))) {
                hashSetOf.add(s.get(right))
                right++
            }
            maxLength = Math.max(maxLength, right - index)
        }

        return maxLength
    }

    fun test5(view: View) {
        val longestPalindrome = longestPalindrome("babad")
        LogUtil.d("longestPalindrome = ${longestPalindrome}")
    }

    /**
     * 动态规划
     *
     * 最长回文子串
     * */
    fun longestPalindrome(s: String): String {

        var ans = ""
        var len = s.length
        val booleanArray = Array(len) { Array(len) { false } }
        val charArray = s.toCharArray()
        for (l in 0 until len) {
            for (i in 0 until len - l) {
                var j = i + l
                when (l) {
                    0 -> booleanArray[i][j] = true
                    1 -> booleanArray[i][j] = (charArray[i] == charArray[j])
                    else -> booleanArray[i][j] = (booleanArray[i + 1][j - 1] && charArray[i] == charArray[j])
                }
                if (booleanArray[i][j] && (l + 1 > ans.length)) {
                    ans = s.substring(i, i + l + 1)
                }
            }

        }
        return ans
    }

    fun test6(view: View) {
        val convert = convert("LEETCODEISHIRING", 3)
        LogUtil.d("convert = ${convert}")
    }

    /**
     * Z字形变换
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *
     * 输入字符串为 "LEETCODEISHIRING" 行数为3时,输出"LCIRETOESIIGEDHN"
     * */
    fun convert(s: String, numRows: Int): String {

        if (numRows == 1) {
            return s
        }

        if (s.length <= numRows) {
            return s
        }

        var list = arrayListOf<StringBuilder>()
        for (i in 0 until numRows) {
            list.add(StringBuilder())
        }

        var line = 0
        val length = s.length
        var b = false
        for (i in 0 until length) {

            list.get(line).append(s.get(i))

            if (line == numRows - 1 || line == 0) b = !b

            if (b) {
                line++
            } else {
                line--
            }
        }

        val sb = StringBuilder()
        for (i in 0 until numRows) {
            sb.append(list.get(i).toString())
        }

        return sb.toString()
    }

    fun test7(view: View) {
        println("reverse(1452) = ${reverse(1452)}")
    }

    /**
     * 整数反转
     *
     * int类型的范围是 -2^31——2^31-1，即-2147483648——2147483647
     * */
    fun reverse(x: Int): Int {

        var resource = x
        var dest = 0

        while (resource != 0) {
            val temp = resource % 10
            resource /= 10

            if (dest > Int.MAX_VALUE / 10 || dest == Int.MAX_VALUE / 10 && temp > Int.MAX_VALUE % 10) {
                return 0
            }
            if (dest < Int.MIN_VALUE / 10 || dest == Int.MIN_VALUE / 10 && temp < Int.MIN_VALUE % 10) {
                return 0
            }
            dest = dest * 10 + temp
        }
        return dest
    }

    fun test8(view: View) {
        println("myAtoi(   -42) = ${myAtoi("   -42")}")
        println("myAtoi(-a42) = ${myAtoi("-a42")}")
        println("myAtoi(42) = ${myAtoi("42")}")
        println("myAtoi(a42) = ${myAtoi("a42")}")
        println("myAtoi(aaaa) = ${myAtoi("aaaa")}")
        println("myAtoi(--42) = ${myAtoi("--42")}")
        println("myAtoi(+42) = ${myAtoi("+42")}")
        println("myAtoi(21474836460) = ${myAtoi("21474836460")}")
    }

    /**
     * 自动机（有限状态机）
     *
     * 注意：1.Int的取值范围；2.value做判断的时候，小心越界
     * */
    fun myAtoi(s: String): Int {
        val hashMapOf = hashMapOf<String, Array<String>>(
                Pair("start", arrayOf("start", "sign", "number", "end")),
                Pair("sign", arrayOf("end", "end", "number", "end")),
                Pair("number", arrayOf("end", "end", "number", "end")),
                Pair("end", arrayOf("end", "end", "end", "end"))
        )
        var currentState = "start"
        var value = 0
        var sign = 1
        var temp = 0

        for (index in s.indices) {
            currentState = hashMapOf.get(currentState)!!.get(getType(s.get(index)))

            when (currentState) {
                "start" -> currentState = "start"
                "sign" -> {
                    if (s.get(index).toString() == "+") sign = 1 else sign = -1
                }
                "number" -> {
                    temp = s.get(index).toString().toInt()

                    if (value * sign < Int.MIN_VALUE / 10 || value * sign == Int.MIN_VALUE / 10 && temp * sign <= Int.MIN_VALUE % 10) {
                        currentState = "end"
                        value = Int.MIN_VALUE
                        sign = 1
                    } else if (value > Int.MAX_VALUE / 10 || value == Int.MAX_VALUE / 10 && temp > Int.MAX_VALUE % 10) {
                        currentState = "end"
                        value = Int.MAX_VALUE
                    } else {
                        value = value * 10 + temp
                    }
                }
                else -> {
                    currentState = "end"
                }
            }

            if (currentState == "end") break;

        }

        return sign * value
    }

    fun getType(first: Char): Int {
        var type = 0
        when {
            first.isWhitespace() -> type = 0
            first.toString() == "+" || first.toString() == "-" -> {
                type = 1
            }
            first.isDigit() -> {
                type = 2
            }
            else -> type = 3
        }
        return type
    }

    fun test9(view: View) {
        println("isPalindrome(-1) = ${isPalindrome(-1)}")
        println("isPalindrome(12321) = ${isPalindrome(12321)}")
        println("isPalindrome(-12321) = ${isPalindrome(-12321)}")
        println("isPalindrome(112321) = ${isPalindrome(112321)}")
        println("isPalindrome(998899) = ${isPalindrome(998899)}")
    }

    /**
     * 使用移动一半数字的算法更佳
     * */
    fun isPalindrome(x: Int): Boolean {
        var value = x
        val arrayListOf = arrayListOf<Int>()
        if (x < 0) {
            return false
        }
        if (x == 0) {
            return true
        }
        while (value != 0) {
            arrayListOf.add(value % 10)
            value = value / 10
        }
        val stringBuilder = StringBuilder()
        for (i in 0 until arrayListOf.size) {
            stringBuilder.append(arrayListOf.get(i))
        }
        return stringBuilder.toString() == x.toString()
    }

    fun test11(view: View) {
        println("maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)) = ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}")
    }

    /**
     * 双指针
     * */
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            if (height[left] <= height[right]) {
                max = Math.max(height[left] * (right - left), max)
                left++
            } else {
                max = Math.max(height[right] * (right - left), max)
                right--
            }
        }

        return max
    }

    fun test12(view: View) {
        LogUtil.d("intToRoman(1994) = ${intToRoman(1994)}")
        LogUtil.d("intToRoman(1834) = ${intToRoman(1834)}")
    }

    /**
     * 方法一、贪心算法
     *
     * 方法二、暴力求解（利用数组把数字穷举会比较简单）
     * */
    fun intToRoman(num: Int): String {
        var num = num
        val numbers = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val stringBuilder = StringBuilder()
        var index = 0
        while (num > 0) {
            while (num >= numbers[index]) {
                num = num - numbers[index]
                stringBuilder.append(romans[index])
            }
            index++
        }
        return stringBuilder.toString()
    }

    fun test13(view: View) {
        LogUtil.d("romanToInt(MCMXCIV) = ${romanToInt("MCMXCIV")}")
    }

    fun romanToInt(s: String): Int {
        var s = s
        val numbers = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romans = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var index = 0
        var value = 0
        while (s.length > 0) {
            while (s.startsWith(romans[index])) {
                s = s.substring(romans[index].length)
                value += numbers[index]
            }
            index++
        }
        return value
    }

    fun test14(view: View) {

        LogUtil.d("longestCommonPrefix(arrayOf(\"flower\",\"flow\",\"flight\")) " +
                "= ${longestCommonPrefix(arrayOf("flower", "flow", "flight"))}")
    }

    /**
     * 纵向扫描
     * */
    fun longestCommonPrefix(strs: Array<String>): String {

        val first = strs[0]
        val length = first.length
        for(i in 0 until length){

            for(j in 1 until  strs.size){
                if (strs[j] == "") {
                    return ""
                }
                if(strs[j].length == i || strs[j][i] != (first[i])){
                    if (i == 0) {
                        return ""
                    }
                    return first.substring(0, i)
                }
            }
        }
        return first
    }

    fun test14_2(view: View) {
        LogUtil.d("longestCommonPrefix_2(arrayOf(\"flower\",\"flow\",\"flight\")) " +
                "= ${longestCommonPrefix_2(arrayOf("flower", "flow", "flight"))}")
        LogUtil.d("longestCommonPrefix_2(arrayOf(\"flight\",\"flow\",\"flower\")) " +
                "= ${longestCommonPrefix_2(arrayOf("flower", "flow", "flight"))}")
        LogUtil.d("longestCommonPrefix_2(arrayOf(\"dog\",\"racecar\",\"car\")) " +
                "= ${longestCommonPrefix_2(arrayOf("dog","racecar","car"))}")
    }

    /**
     * 字典树
     * */
    fun longestCommonPrefix_2(strs: Array<String>): String {

        val size = strs.size
        var treeNode = TreeNode('s'.toChar())

        for(i in 0 until size){
            addNode(strs[i], treeNode)
        }
        val sb = StringBuilder()
        while(treeNode.children.size == 1 && !treeNode.isEnd){
            sb.append(treeNode.children.keys.iterator().next())
            treeNode = treeNode.children[treeNode.children.keys.iterator().next()]!!
        }
        return sb.toString()
    }

    private fun addNode(s: String, root: TreeNode) {

        var root = root
        val length = s.length
        for (i in 0 until length) {

            val char = s[i]
            val node = TreeNode(char)
            if (!root.children.containsKey(node.value)) {
                root.children.put(node.value, node)
            }
            root = root.children[node.value]!!
        }
        root.isEnd = true
    }

    fun test15(view: View) {
        var nums = intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6)
        LogUtil.d("threeSum(nums) = ${threeSum(nums)}")
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        var list : MutableList<Int>?= null
        val listOf = mutableListOf<List<Int>>()

        nums.sort()
        for(i in nums.indices){
            if(i > 0 && nums[i] == nums[i-1]){
                continue
            }
            var left = i
            var right = nums.size - 1
            while(left <right){
                left++
                while(left <right && nums[left] == nums[left-1] && left-1>i){
                    left++
                }
                while(left <right && nums[left] +nums[right] < -nums[i]){
                    left++
                    while(left <right && nums[left] == nums[left-1]){
                        left++
                    }
                }
                while(left <right && nums[left] +nums[right] > -nums[i]){
                    right--
                    while(left <right && nums[right] == nums[right+1]){
                        right--
                    }
                }
                if(nums[left] +nums[right] == -nums[i] && left <right){
                    list = mutableListOf()
                    list.add(nums[i])
                    list.add(nums[left])
                    list.add(nums[right])
                    listOf.add(list)
                }
            }

        }

        return listOf
    }

    fun test16(view: View) {
        var nums = intArrayOf(-1,0,1,1,55)
        LogUtil.d("threeSumClosest(nums, target) = ${threeSumClosest(nums, 3)}")
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {

        nums.sort()
        var min = nums[0]+nums[1]+nums[2]
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var right = nums.size - 1
            for (left in i + 1 until nums.size - 1) {
                if (left - 1 > i && nums[left] == nums[left - 1]) {
                    continue
                }

                if(nums[left] + nums[right] + nums[i] <= target){
                    if (Math.abs(nums[left] + nums[right] + nums[i] - target) < Math.abs(min - target)) {
                        min = nums[left] + nums[right] + nums[i]
                    }
                    continue
                }

                while(left < right && nums[left] + nums[right] + nums[i] >= target){
                    if (Math.abs(nums[left] + nums[right] + nums[i] - target) < Math.abs(min - target)) {
                        min = nums[left] + nums[right] + nums[i]
                    }
                    if(left < right){
                        right--
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--
                    }
                }
            }
        }

        return min
    }
}
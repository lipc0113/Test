package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.topfun.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第三章 函数的定义与调用
 */
class ExampleUnitTest2 {

    /*
    * 3.6局部函数和扩展
    * */
    @Test
    fun addition_isCorrect8() {

        var i = 1
        var j = 2
        var m = 100

        fun add10(i: Int) = i + 10

        fun add11(i: Int): Int {
            return i + m
        }

        println("result=${add10(i) + add11(j)}")
    }

    /*
    * 3.5字符串和正则表达式的处理
    * */
    @Test
    fun addition_isCorrect7() {
        val str = "12.345-6.A"
        println(str.split("."))
        println(str.split(".", "-"))
        println(str.split(".".toRegex()))

        val filepath = "a/b/c/d.txt"
        // 两种写法都可以
//        val toRegex = """(.+)/(.+)\.(.+)""".toRegex()
        val toRegex = "(.+)/(.+)\\.(.+)".toRegex()
        val matchEntire = toRegex.matchEntire(filepath)
        if (matchEntire != null) {
            val (path, name, extension) = matchEntire.destructured
            println("$path, $name, $extension")
        }
    }

    /*
    * 3.4中缀调用
    * */
    @Test
    fun addition_isCorrect6() {
        println(mapOf(1 to2 "l", 2 to2 "p"))
        val (a, b) = 3 to2 "c"
        println("a=${a}, b=${b}")
    }

    /*
    * 3.4可变参数、中缀调用和库的支持
    *
    * */
    @Test
    fun addition_isCorrect5() {
        println(listOf2(1, 2, 3, 4, 5))
        println(listOf2("l", "p", "c", "0", "1", "1", "3"))
    }

    /*
    * 3.3扩展函数和属性
    *
    * 扩展函数不能重写
    * */
    @Test
    fun addition_isCorrect4() {
        println("lipc0113".lastChar2())
        println("lipc0113".lengthIsEven)
    }

    /*
    * 3.2顶层函数和属性
    * */
    @Test
    fun addition_isCorrect3() {
        println(subHalf("lipc0113"))
    }

    /*
    * 3.2命名参数、默认参数值
    * */
    @Test
    fun addition_isCorrect2() {
//        add(123, "lpc")
//        add(1)
        add(1, s = "123")
    }

    /*
    * 3.1在kotlin中创建集合
    * */
    @Test
    fun addition_isCorrect() {
        val list = listOf(1, 2, 3)
        println(list.javaClass)
        println(list.toString())

        val arrayList = arrayListOf(1, 2, 3)
        println(arrayList.javaClass)
        println(arrayList.toString())

        val set = setOf(1, 2, 3)
        println(set.toString())

        val map = mapOf(1 to "1", 2 to "2", 3 to "3")
        println(map.toString())

        //TODO SparseArray如何使用？？？
//        val sparseIntArray = SparseIntArray()
//        println(sparseIntArray.toString())
    }

    private fun add(i: Int, s: String = "lipc0113") {
        println("i=${i}, s=${s}")
    }
}


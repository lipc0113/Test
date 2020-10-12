package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.test.topfun.filterCustom
import com.lpc.test.kotlin_lib.test.topfun.filterCustom2
import com.lpc.test.kotlin_lib.test.topfun.filterCustom3
import com.lpc.test.kotlin_lib.test.topfun.filterCustom4
import org.junit.Test
import java.util.concurrent.locks.ReentrantLock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第八章 高阶函数：lambda作为形参和返回值
 */
class ExampleUnitTest6 {

    val list = arrayListOf("lipc", "syj")

    /**
     * 局部返回-匿名函数
     * */
    @Test
    fun addition_isCorrect8() {

        list.forEach(fun(str) {
            if (str == "syj") {
                println("找到 = syj")
                return
            }
        })
        println("forEach = 结束")
    }

    /**
     * 局部返回-使用标签返回
     * */
    @Test
    fun addition_isCorrect7() {

        list.forEach {
            if (it == "syj") {
                println("找到 = syj")
                return@forEach
            }
        }
        println("forEach = 结束")
    }

    /**
     * 非局部返回
     * */
    @Test
    fun addition_isCorrect6() {

        list.forEach {
            if (it == "syj") {
                println("找到 = syj")
                return
            }
        }
        println("forEach = 结束")
    }

    /**
     * 非内联函数
     * */
    @Test
    fun addition_isCorrect5() {
        val reentrantLock = ReentrantLock()
        val synchronized = com.lpc.test.kotlin_lib.test.topfun.synchronized2(reentrantLock) {
            555
        }
        println("synchronized = " + synchronized)
    }

    /**
     * 内联函数
     * */
    @Test
    fun addition_isCorrect4() {
        val reentrantLock = ReentrantLock()
        val synchronized = com.lpc.test.kotlin_lib.test.topfun.synchronized(reentrantLock) {
            555
        }
        println("synchronized = " + synchronized)
    }

    /**
     * 返回函数的函数
     * */
    @Test
    fun addition_isCorrect3() {
        val calculator = getCalculator()
        println("calculator(2, 4) = " + calculator(2, 4))
    }

    /**
     * 函数类型的默认函数值和null值
     * */
    @Test
    fun addition_isCorrect2() {

        val str = "lipc0113"
        val str2 = "syj"
        str.filterCustom { it -> it == 'l' }
        str2.filterCustom2()

        str.filterCustom3(null)
        str.filterCustom4(null)
    }

    /**
     * 调用作为参数的函数
     * */
    @Test
    fun addition_isCorrect() {
        testCalculate { a, b -> a * b + 1 }
    }

    private fun getCalculator(): (a: Int, b: Int) -> Int {
        return { a, b -> a * b + 1 }
    }

    private fun testCalculate(add: (a: Int, b: Int) -> Int) {
        println("testCalculate(2, 3) = " + add(2, 3))
    }

}


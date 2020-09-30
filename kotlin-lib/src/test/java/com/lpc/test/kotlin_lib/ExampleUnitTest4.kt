package com.lpc.test.kotlin_lib

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第六章 6.2 基本数据类型和其它数据类型
 */
class ExampleUnitTest4 {

    /**
     * Nothing类型
     * */
    @Test
    fun addition_isCorrect5() {
        var a: String? = null
        printlnTest(a?.length ?: printlnException())
    }

    /**
     * Unit类型
     * */
    @Test
    fun addition_isCorrect4() {
        class MyPerson : Person<String> {

            override fun test(): String {
                return ""
            }
        }

        class MyPerson2 : Person<Unit> {
            override fun test(): Unit {
            }
        }
    }

    /**
     * Any 是所有类型的超类
     * */
    @Test
    fun addition_isCorrect3() {
        var any: Any = 42
    }

    /**
     * 数字转换
     * */
    @Test
    fun addition_isCorrect2() {
        var b: Byte = 1
        var i = 1
        var j: Long = i + 1L
        printlnTest(42)
    }

    /**
     * 数字转换
     * */
    @Test
    fun addition_isCorrect() {
        var i = 1
        // i必须toLong(),否则编译报错
        var j: Long = i.toLong()

        // m必须声明L,否则编译报错
        var m = 1L
        var list = listOf(1L, 2L, 3L)
        println("i in list" + (m in list))
    }

    private interface Person<T> {
        fun test(): T
    }

    private fun printlnTest(i: Int) {}

    private fun printlnException(): Nothing {
        throw RuntimeException("RuntimeException啊啊啊")
    }
}


package com.lpc.test.kotlin_lib

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val s1 = "kotlin"

    /*
    * 2.5异常
    * */
    @Test
    fun addition_isCorrect9() {
        println("i=${test()}")
    }

    /*
    * 2.5异常
    * */
    @Test
    fun addition_isCorrect8() {
        try {
            val i = 1 / 0
            println("i=$i")
        } catch (e: Exception) {
//            println("i不能除以0")
            throw Exception()
        } finally {
            println("finish")
        }
    }

    /*
    * 2.4while循环和for循环
    * */
    @Test
    fun addition_isCorrect7() {
        println("10在9到100之间${judge(10)}")
        println("8在9到100之间${judge(8)}")

        println("10不在9到100之间${judge2(10)}")
        println("8不在9到100之间${judge2(8)}")
    }

    /*
    * 2.4while循环和for循环
    * */
    @Test
    fun addition_isCorrect6() {
        travalsalMap()
    }

    /*
    * 2.4while循环和for循环
    * */
    @Test
    fun addition_isCorrect5() {
        // while
        travalsal()

        // for
        travalsal2()
    }

    /*
    * 2.3when
    * */
    @Test
    fun addition_isCorrect4() {
        println(getColor(Color.RED))

        println(getColorSet(Color.RED, Color.Blue))
        println(getColorSet(Color.RED, Color.Green))

        println(getColor2(Color.RED))

        println(getValue(1))
        println(getValue(Color.RED))
        println(getValue(123))
    }

    /*
    * 2.3枚举
    * */
    @Test
    fun addition_isCorrect3() {
        println(Color.RED)
        println(Color.RED.ordinal)
        println(Color.valueOf("RED"))
        // 运行错误，没有此枚举
//        println(Color.valueOf("red"))

        println(Color2.RED)
        println(Color2.RED.rgb())
    }

    /*
    * 2.2类和属性
    * */
    @Test
    fun addition_isCorrect2() {
        val person = Person(123, "lpc")
        println("person=${person}")

        // val属性不可更改
//        person.id = 1234
        person.name = "lipc0113"
        println("person.name=${person.name}")

        println("person.isLpc=${person.isLpc}")
        println("person.isFirst=${person.isFirst()}")

        person.name = "lpc"
        println("person.isLpc=${person.isLpc}")
    }

    /*
    * 2.1函数、变量、字符串模板
    * */
    @Test
    fun addition_isCorrect() {
        println("Hello $s1")
        println("Hello ${s1}")
    }

    fun getColor(c: Color): String =
            when (c) {
                Color.RED -> "red"
                Color.Blue -> "blue"
                Color.Green -> "green"
                else -> "not know"
            }

    fun getColorSet(c: Color, c2: Color): String =
            when (setOf(c, c2)) {
                setOf(Color.RED, Color.Blue) -> "red and blue"
                else -> "not know"
            }

    fun getColor2(c: Color): String =
            when {
                c == Color.RED -> "red"
                else -> "not know"
            }

    fun getValue(c: Any?): String =
            when (c) {
                1 -> "特定值"
                Color.RED -> "枚举"
                is Int -> "数字"
                is String -> "字符串"
                else -> "not know"
            }

    fun travalsal() {
        var i = 1
        do {
            println("i=${i}")
            i++
        } while (i < 5)
    }

    fun travalsal2() {
//        for (i in 11..20) {
//            println("i=${i}")
//        }

//        for (i in 11..20 step 2) {
//            println("i=${i}")
//        }

//        for (i in 20 downTo 11 step 2) {
//            println("i=${i}")
//        }

//        for (i in 11 until 20) {
//            println("i=${i}")
//        }

        for (i in 11..20 - 2) {
            println("i=${i}")
        }
    }

    fun travalsalMap() {
        val hashMap = HashMap<Int, String>()
        hashMap[0] = "10"
        hashMap[1] = "11"
        hashMap[2] = "12"

        for ((i, s) in hashMap) {
            println("hashMap${i}=${s}")
        }

        hashMap[0] = "100"
        println("hashMap0 = ${hashMap[0]}")
    }

    private fun judge(i: Int) =
            i in 9..100

    private fun judge2(i: Int) =
            i !in 9..100

    private fun test(): Int =
            try {
                val i = 1 / 0
                i
            } catch (e: Exception) {
                throw Exception()
            } finally {
                println("finish")
            }
}


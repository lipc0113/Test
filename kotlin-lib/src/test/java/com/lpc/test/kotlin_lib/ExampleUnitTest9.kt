package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.bean.FilterL
import com.lpc.test.kotlin_lib.bean.HTML
import com.lpc.test.kotlin_lib.bean.createHtml
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第十一章 DSL构建
 */
class ExampleUnitTest9 {

    val list = arrayListOf("lipc", "syj")

    /**
     * kotlin should start with "kot"
     * */
    @Test
    fun addition_isCorrect10() {
        println("kotlin" should start with "kot")
        println("kotlin" should start with "java")
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect9() {

        val filterL = FilterL()

        val filter = list.filter {
            filterL(it)
        }

        println("filter = ${filter}")
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect8() {
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect7() {
        val html = HTML()
        html("test")
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect6() {
        println("createHtml() = ${createHtml()}")
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect5() {
        val stringBuilder = StringBuilder()
        stringBuilder.apply2 {
            append("!!!")
            append("???")
            apply2 {
                append("......")
            }
        }
        println("stringBuilder = ${stringBuilder}")
    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect4() {
        val stringBuilder = StringBuilder()
        with2(stringBuilder) {
            append("!!!")
            append("???")
            append("...")
            println("stringBuilder = ${stringBuilder}")
        }
    }

    /**
     * */
    @Test
    fun addition_isCorrect3() {
        val stringBuilder = StringBuilder()
        stringBuilder.apply2 {
            append("!!!")
            append("???")
        }
        println("stringBuilder = ${stringBuilder}")
    }

    /**
     * */
    @Test
    fun addition_isCorrect2() {
        println("buildString2 = ${
            buildString2 {
                append("Hello ")
                append("World! ")
            }
        }")
    }

    /**
     * */
    @Test
    fun addition_isCorrect() {
        val buildString = buildString {
            it.append("Hello ")
            it.append("World! ")
        }
        println("buildString = ${buildString}")
    }

    object start

    infix fun String.should(s: start): StartWrapper = StartWrapper(this)

    class StartWrapper(val string: String) {
        infix fun with(str: String): Boolean {
            return string.startsWith(str)
        }
    }

    fun <T, R> with2(t: T, action: T.() -> R) {
        t.action()
    }

    fun <T> T.apply2(action: T.() -> Unit): T {
        action()
        return this
    }

    fun testStringBuilder(action: StringBuilder.() -> Unit) = StringBuilder().apply { action }.toString()

    fun buildString2(
            action: StringBuilder.() -> Unit
    ): String {
        val stringBuilder = StringBuilder()
        stringBuilder.action()
        return stringBuilder.toString()
    }

    fun buildString(
            action: (StringBuilder) -> Unit
    ): String {
        val stringBuilder = StringBuilder()
        action(stringBuilder)
        return stringBuilder.toString()
    }

}


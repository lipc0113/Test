package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.test.topfun.filterCustom2
import com.lpc.test.kotlin_lib.test.topfun.filterCustom3
import com.lpc.test.kotlin_lib.test.topfun.filterCustom4
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第九章 泛型
 */
class ExampleUnitTest7 {

    val list = arrayListOf("lipc", "syj")

    /**
     *
     * */
    @Test
    fun addition_isCorrect9() {

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

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect6() {

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect5() {

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect4() {

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect3() {

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect2() {

    }

    /**
     *
     * */
    @Test
    fun addition_isCorrect() {
        // 这两个编译报错。当接收集合为只读时，才可以
//        val list = mutableListOf("lipc", "syj")
//        val list = mutableListOf<String>("lipc", "syj")

        val list = mutableListOf<Any>("lipc", "syj")
        addAnswer(list)

        // 当接收集合为只读时，可以
        val list2 = listOf("lipc", "syj")
        addAnswer2(list2)

        val str = "lipc"
        addAnswer3(str)
    }

    fun addAnswer(list: MutableList<Any>) {
        list.add("111")
    }

    fun addAnswer2(list: List<Any>) {
    }

    fun addAnswer3(str: Any) {

    }
}


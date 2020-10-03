package com.lpc.test.kotlin_lib

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第六章 6.2 基本数据类型和其它数据类型
 *
 * 第六章 6.3 集合与数组
 */
class ExampleUnitTest4 {

    /**
     * 对象和基本数据类型类型的数组
     * */
    @Test
    fun addition_isCorrect9() {
        var array = arrayOf("l")
        println("array = " + array[0])

        var array2 = arrayOfNulls<String>(5)
        array2[0] = "l"
        println("array2 = " + array2[0])
        println("array2 = " + array2.size)

        var array3: Array<String> = Array<String>(5) { i -> "lpc" + i }
        println("array3 = " + array3[0])
        println("array3 = " + array3.size)

        var array4 = IntArray(5)
        array4[0] = 1
        println("array4 = " + array4[0])

        var array5 = intArrayOf(5, 6)
        println("array5 = " + array5[0])
        println("array5 = " + array5.size)

        var array6: IntArray = IntArray(5) { i -> 10 + i }
        println("array6 = " + array6[0])
        println("array6 = " + array6.size)
    }

    /**
     * kotlin集合和java
     *
     * listOf、setOf、mapOf对应的只读集合
     *
     * 当在kitlin中继承java类或者实现java接口时，要仔细考虑参数的可变性、可空性
     * */
    @Test
    fun addition_isCorrect8() {
        var collection: Collection<String> = listOf("lll")
        println("collection = " + collection.toString())

//        var collection2 : MutableCollection<String> = setOf("lll")
//        println("collection2 = " + collection2.toString())

//        var collection3: MutableMap<String, String> = mapOf(Pair("lll", "111"))
//        collection3.put("333", "333")
//        println("collection3 = " + collection3.toString())
    }

    /**
     * 只读集合与可变集合
     * */
    @Test
    fun addition_isCorrect7() {
        var collection: Collection<String> = arrayListOf("lll")
//        collection.add("lpc")
        println("collection = " + collection.toString())

        var collection2: MutableCollection<String> = arrayListOf("lll")
        collection2.add("lpc")
        println("collection2 = " + collection2.toString())
    }

    /**
     * 可空性和集合
     * */
    @Test
    fun addition_isCorrect6() {
        var list = arrayListOf<String?>()
        list.add("lpc")
        list.add("")
        list.add(null)
        println("list = " + list.toString())

        val filterNotNull = list.filterNotNull()
        println("filterNotNull = " + filterNotNull.toString())
        println("filterNotNull = " + filterNotNull.size)
    }

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


package com.lpc.test.kotlin_lib

import org.junit.Test
import java.util.*
import kotlin.Comparator

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
     * 星号投影
     * */
    @Test
    fun addition_isCorrect10() {
        val list = arrayListOf("lipc", "syj")
        val list2 = arrayListOf(1, 2)
        val list3: ArrayList<*> = if(1 == 2/2) list else list2
        // 编译报错
//        list3.add("123")
//        list3.add(123)
        // 不可写，但可读
        println("list3.first() = " + list3.first())
    }

    /**
     * 逆变：反转子类型化关系
     * */
    @Test
    fun addition_isCorrect9() {
        val MyComparator = Comparator<Any> { e1, e2 ->
            e1.hashCode() - e2.hashCode()
        }

        val StringComparator = Comparator<String> { e1, e2 ->
            e1.hashCode() - e2.hashCode()
        }
        val list = mutableListOf<String>("1", "2")
        list.sortWith(MyComparator)
        println("list = " + list)
        list.sortWith(StringComparator)
        println("list = " + list)
    }

    /**
     * 协变，保留子类型化关系
     * */
    @Test
    fun addition_isCorrect8() {

        val list = mutableListOf<String>("lipc", "syj")
        addAnswer4(list)
    }

    /**
     * 变型：泛型和子类型化
     * */
    @Test
    fun addition_isCorrect7() {
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

    /**
     * 使用实化类型参数代替类引用
     * */
    @Test
    fun addition_isCorrect6() {
        val kClass = String::class
        val load = ServiceLoader.load(String::class.java)
        println(kClass)
        println(load)
        println(kClass == load)

        val loadService = loadService<String>()
        println(loadService)
        println(load.javaClass == loadService.javaClass)
    }

    /**
     * 运行时的泛型：擦除和实化类型参数
     *
     * inline和reified共同使用时，可以使用实化类型参数
     * */
    @Test
    fun addition_isCorrect5() {

        println("get3<String>(\"123\") = " + get3<String>("123"))
        println("get3<Int>(\"123\") = " + get3<Int>("123"))
    }

    /**
     * 运行时的泛型：擦除和实化类型参数
     * */
    @Test
    fun addition_isCorrect4() {

        val listOf = listOf("123", "456")
        val listof2 = listOf(123, 456)

        if (listOf is List<String>) {

        }

        // 编译报错,在运行时，会类型参数，不保留泛型信息。所以会编译报错
//        if (listof2 is List<String>) {
//
//        }

        // *号投影相当于java中的List<?>,这只能检测到listof2是不是List
        if (listof2 is List<*>) {

        }
    }

    /**
     * 让类型形参非空
     *
     * 类型形参默认是可以为null的，所以可以认为 :Any
     * */
    @Test
    fun addition_isCorrect3() {
        println("get2(null) = " + get2(null))
        println("get2(null) = " + get2(123))
        // 编译报错
//        println("get22(null) = " + get22(null))
    }

    /**
     * 类型参数约束
     * */
    @Test
    fun addition_isCorrect2() {
        // 编译报错
//        println("get(10) = " + get("123"))
        println("get(10) = " + get(10))

        println("compare(\"a\", \"b\") = " + compare("a", "b"))

        println("compare(100, 101) = " + compare(100, 101))
    }

    fun <T> get4(list: List<*>) {

    }

    fun <T> get5(list: List<T>) {

    }

    fun addAnswer(list: MutableList<Any>) {
        list.add("111")
    }

    fun addAnswer2(list: List<Any>) {
    }

    fun addAnswer3(str: Any) {

    }

    fun addAnswer4(list: MutableList<out Any>) {
    }

    inline fun <reified T> loadService() = ServiceLoader.load(T::class.java)


    inline fun <reified T> get3(value: Any) = value is T

// 编译报错
//    fun <T> get3(value:Any) = value is T

    fun <T : Any> get22(t: T): String {
        if (t == null) {
            return "null"
        }
        return "test"
    }

    fun <T> get2(t: T): String {
        if (t == null) {
            return "null"
        }
        return "test"
    }

    fun <T : Comparable<T>> compare(first: T, two: T): T {
        return if (first >= two) first else two
    }

    fun <T : Number> get(t: T): Int {
        when (t) {
            is Int -> {
                var tt = t as Int
                return ++tt
            }
        }
        return 0
    }
}


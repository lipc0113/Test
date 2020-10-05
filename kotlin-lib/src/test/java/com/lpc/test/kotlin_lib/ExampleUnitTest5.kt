package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.bean.Foo
import com.lpc.test.kotlin_lib.bean.Point
import com.lpc.test.kotlin_lib.bean.Point2
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第七章 运算符重载及其它约定
 */
class ExampleUnitTest5 {

    /**
     * 委托属性
     * */
    @Test
    fun addition_isCorrect9() {

        val foo = Foo()
        foo.i = 10
        println("foo.i = ${foo.i}")

        val foo2 = Foo()
        println("foo2.toString() = ${foo2.toString()}")
        println("foo2.emails = ${foo2.emails}")

        // 使用委托属性把值存到map中
        val foo3 = Foo()
        println("foo3.key = ${foo3.key}")
        println("foo3.key2 = ${foo3.key2}")
    }

    /**
     * 解构声名和组件函数
     * */
    @Test
    fun addition_isCorrect8() {

        val point = Point(10, 10)
        val (m, n) = point
        println("m = ${m}, n = ${n}")

        val list = listOf(11, 12, 13)
        val (m2, n2) = list
        println("m2 = ${m2}, n = ${n2}")
    }

    /**
     * 集合与区间的约定
     *
     * 此外，还有in=contains  ..=rangeTo(闭区间)  util(开区间)  in用在for循环中==iterator
     * */
    @Test
    fun addition_isCorrect7() {

        val map = mutableMapOf("1" to "1", "2" to "2")
        map["1"] = "11"
        println("${map["1"]}")

        var point = Point2(10, 20)
        println("${point[1]}")

        var point3 = Point2(10, 21)
        point3[1] = 31
        println("${point3}")

        var point2 = Point2(10, 21)
        println("${point2[10]}")
    }

    /**
     * 重载比较运算符
     * */
    @Test
    fun addition_isCorrect6() {

        var point = Point(10, 10)
        println("${point >= Point(10, 10)}")
        println("${point >= Point(10, 11)}")
        println("${point >= Point(9, 10)}")
    }

    /**
     * 重载比较运算符
     * */
    @Test
    fun addition_isCorrect5() {

        var point = Point(10, 10)
        println("${point == Point(10, 10)}")
        println("${point == Point(10, 12)}")
        println("${point == null}")
    }

    /**
     * 重载算数运算符
     * */
    @Test
    fun addition_isCorrect4() {

        var point = Point(10, 10)
        println("${++point}")
    }

    /**
     * 重载算数运算符
     * */
    @Test
    fun addition_isCorrect3() {
        // 这里会编译报错
//        var list2 = mutableListOf<String>("1", "2", "3")
//        list2 += "4"

        // 只读集合,这时会创建新的集合副本
        var list = listOf<String>("1", "2", "3")
        list += "4"
        println("${list}")

        // 可变集合，这里list2要定义为val，不然编译报错
        val list2 = arrayListOf("1", "2", "3")
        list2 += "4"
        println("${list2}")
    }

    /**
     * 重载算数运算符
     * */
    @Test
    fun addition_isCorrect2() {

        var point2 = Point2(10, 10)
        point2 += Point2(13, 14)
        println("${point2}")
    }

    /**
     * 重载算数运算符
     * */
    @Test
    fun addition_isCorrect() {

        var point = Point(10, 10)
        println("${point + (Point(3, 4))}")

        var point2 = Point(10, 10)
        println("${point2 + 5}")

        var point3 = Point(10, 10)
        println("${point3 + "123"}")
    }
}


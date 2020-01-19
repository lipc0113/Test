package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.bean.Button
import com.lpc.test.kotlin_lib.bean.Expr
import com.lpc.test.kotlin_lib.bean.Out
import com.lpc.test.kotlin_lib.bean.View
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * 第四章 类、对象和接口
 */
class ExampleUnitTest3 {

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect6() {
    }

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect5() {
    }

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect4() {
    }

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect3() {
        val sum = Expr.Sum()

        fun getType(expr: Expr) =
                when (expr) {
                    is Expr.Sum -> "sum"
                    is Expr.Num -> "num"
                }

        println(getType(sum))
    }

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect2() {
        val inner = Out().Inner()
        inner.println2()

        val inner2 = Out.Inner2()
        inner2.println2()
    }

    /*
    * 4.1定义类继承结构
    * */
    @Test
    fun addition_isCorrect() {
        val view = View()
        // protected只能在子类中调用
//        view.printlnLog()
        view.onClick()
        view.onLongClick()

        val btn = Button()
        btn.onClick()
        btn.onLongClick()
    }

}


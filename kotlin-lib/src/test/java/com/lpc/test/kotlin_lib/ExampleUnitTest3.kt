package com.lpc.test.kotlin_lib

import com.lpc.test.kotlin_lib.bean.*
import com.lpc.test.kotlin_lib.interfaces.Clickable
import com.lpc.test.kotlin_lib.interfaces.Clickable2
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
    * 4.4"object"关键字
    *
    * 匿名内部类可以引用外部的变量，而不用final修饰
    * */
    @Test
    fun addition_isCorrect9() {
        var count = 0
        val list = arrayListOf<Clickable>()
        list.add(
                object : Clickable {
                    override fun onClick() {
                        println("匿名内部类")
                        count++
                    }

                }
        )

        val v2 = object : Clickable, Clickable2 {
            override fun onClick() {
                println("匿名内部类2")
                count++
            }

            override fun onLongClick() {
                super<Clickable>.onLongClick()
                super<Clickable2>.onLongClick()
            }

        }

        list.add(v2)
        println(list.size)
        println("点击次数${count}")
    }

    /*
    * 4.4"object"关键字
    * */
    @Test
    fun addition_isCorrect8() {
        println(User5.MyFactory)
        val user = User5.MyFactory.getUser5()
        println(user)
        val user2 = User5.MyFactory.getUser5()
        println(user2)
        println(user === user2)

        println(User5.age)
        println(User5.log())
    }

    /*
    * 4.4"object"关键字
    * */
    @Test
    fun addition_isCorrect7() {
        println(UserManager.size())
        val user = User5(1001, "1001")
        val user2 = User5(1002, "1002")
        val user3 = User5(1001, "1002")
        UserManager.mList.add(user)
        UserManager.mList.add(user2)
        UserManager.mList.add(user3)
        println(UserManager.size())

        println("排序前")
        UserManager.println()
        UserManager.mList.sortWith(User5.MyComparator)
        println("排序后")
        UserManager.println()
    }

    /*
    * 4.3数据类和委托类
    * */
    @Test
    fun addition_isCorrect6() {
        val buttonWrap = ButtonWrap()
        buttonWrap.onClick()
        buttonWrap.onLongClick()
    }

    /*
    * 4.3数据类和委托类
    * */
    @Test
    fun addition_isCorrect5() {
        val teacher = Teacher(101, "lpc")
        val teacher2 = Teacher(102, "syj")
        val teacher3 = Teacher(101, "lpc")
        val teacher4 = teacher.copy()
        val teacher5 = teacher.copy(102, "lpc")
        println("${teacher}")
        println("${teacher.equals(teacher2)}")
        println("${teacher == teacher2}")
        println("${teacher == teacher3}")
        println("${teacher.hashCode()}")
        println("${teacher2.hashCode()}")
        println("${teacher3.hashCode()}")
        println("${teacher4}")
        println("${teacher5}")
    }

    /*
    * 4.2声明一个带非默认构造方法或属性的类
    * */
    @Test
    fun addition_isCorrect4() {
        val user = User1(101, "lpc")
        user.name = "lipc0113"
        println("user:${user}")

        val user2 = User2(101, "lpc")
        // set访问器私有
//        user2.name = "lipc0113"
        println("user:${user2}")

        val user3 = User3(101, "lpc")
        user3.name = "lipc0113"
        println("user:${user3}")

        // 构造器类型为private
//        val user4 = User4(101, "lpc")
//        user4.name = "lipc0113"
//        println("user:${user4}")

        val childrenUser = ChildrenUser(102)
        println("childrenUser:${childrenUser}")

        childrenUser.palyBall()
        childrenUser.ball = "足球"
        childrenUser.palyBall()

        Student("足球").palyBall()

        val user5 = User5()
        println("user:${user5}")

        val user55 = User5(101, "lipc0113")
        println("user:${user55}")

        val user6 = User6()
        println("user:${user6}")
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


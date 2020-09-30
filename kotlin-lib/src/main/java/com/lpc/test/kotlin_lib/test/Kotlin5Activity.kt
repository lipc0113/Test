package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.bean.Person
import com.lpc.test.kotlin_lib.test.topfun.log
import com.lpc.test.kotlin_lib.test.utils.LogUtil
import java.lang.StringBuilder

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:23 2020-01-15
 * @ Description：
 */
class Kotlin5Activity : AppCompatActivity() {

    val peoples = listOf(Person("lipc", 30), Person("syj", 28), Person("pm", 28))
    lateinit var tvTest: TextView
    lateinit var tvTest2: TextView
    lateinit var tvTest3: TextView
    lateinit var tvTest4: TextView
    lateinit var tvTest5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin5);
        initView()
        initData()
        initData2()
        initData3("name")
        initData4()
        initData5()
        initData6()
        initData7()
    }

    /*
    * 5.5 带接收者的lambda："with"和"apply"
    * */
    private fun initData7() {
        val stringBuilder = StringBuilder()
        with(stringBuilder) {
            append("123")
            append("456")
            append("789")
        }
        LogUtil.d("with() = " + stringBuilder)

        val apply = StringBuilder().apply {
            append("111")
            append("222")
            append("333")
        }
        LogUtil.d("apply() = " + apply)
    }

    /*
    * 5.4 使用java函数式接口
    * */
    private fun initData6() {
        tvTest4.setOnClickListener { LogUtil.d("把lambda当做参数传给java方法") }

        val listener = View.OnClickListener { LogUtil.d("SAM构造方法") }
        tvTest5.setOnClickListener(listener)
    }

    /*
    * 5.3 序列
    * */
    private fun initData5() {
        val toList = peoples.asSequence().map { it.name }.filter { it.startsWith("l") }.toList()
        LogUtil.d("toList.toString() = " + toList.toString())
    }

    /*
    * 5.2集合的函数式API
    * */
    private fun initData4() {
        val filterList = peoples.filter {
            it.age == 30
        }
        LogUtil.d("filterList--->$filterList")

        val filterList2 = peoples.map {
            it.name
        }
        LogUtil.d("filterList2--->$filterList2")

        val isAll28 = peoples.all {
            it.age == 28
        }
        LogUtil.d("isAll28--->$isAll28")

        val isAny28 = peoples.any {
            it.age == 28
        }
        LogUtil.d("isAny28--->$isAny28")

        val count28 = peoples.count {
            it.age == 28
        }
        LogUtil.d("count28--->$count28")

        val person28 = peoples.find {
            it.age == 28
        }
        LogUtil.d("person28--->$person28")

        val groupByList = peoples.groupBy {
            it.age
        }
        LogUtil.d("groupByList--->$groupByList")

        val strings = listOf("adc", "cdf")
        val flatMap = strings.flatMap { it.toList() }
        LogUtil.d("flatMap--->$flatMap")
    }

    fun initView() {
        var clickCount = 0
        tvTest = findViewById<TextView>(R.id.tv_test)
        tvTest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                LogUtil.d("view=${v}")
                finish()
            }
        })

        tvTest2 = findViewById<TextView>(R.id.tv_test2)
        // 5.1.1作为函数参数的代码块
        tvTest2.setOnClickListener {
            LogUtil.d("view=${tvTest2}")
            // 5.1.4在作用域中访问变量2
            clickCount++
            LogUtil.d("clickCount=$clickCount")
        }

        tvTest3 = findViewById(R.id.tv_test3)
        tvTest3.setOnClickListener {
            LogUtil.d("成员引用")
            // 成员引用
            run(::log)
        }

        tvTest4 = findViewById(R.id.tv_test4)
        tvTest5 = findViewById(R.id.tv_test5)
    }

    fun initData() {
        // 5.1.2Lammbda与集合
        tvTest.setText(peoples.maxBy { it.age }?.name)
        tvTest2.setText(peoples.maxBy(Person::age)?.age.toString())
    }

    fun initData2() {
        // 5.1.3Lambda表达式的语法
        val sum = { x: Int, y: Int -> x + y }
        LogUtil.d(sum(1, 2).toString())

        //Lambda表达式的省略过程优化
        LogUtil.d("1:::" + peoples.maxBy({ p: Person -> p.age })!!.name);
        LogUtil.d("2:::" + peoples.maxBy() { p: Person -> p.age }!!.name);
        LogUtil.d("3:::" + peoples.maxBy { p: Person -> p.age }!!.name);
        LogUtil.d("4:::" + peoples.maxBy { p -> p.age }!!.name);
        val test = { p: Person -> p.age }
        LogUtil.d("4:::" + peoples.maxBy(test)!!.name);
    }

    fun initData3(prefix: String) {
        // 5.1.4在作用域中访问变量
        peoples.forEach {
            LogUtil.d("$prefix:${it.name}")
        }
    }
}
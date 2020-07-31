package com.lpc.test.kotlin_lib

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.test.Person
import com.lpc.test.kotlin_lib.utils.LogUtil

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:23 2020-01-15
 * @ Description：
 */
class KotlinActivity : AppCompatActivity() {

    lateinit var tvTest: TextView
    lateinit var tvTest2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin);
        initView()
        initData()
    }

    fun initView() {
        tvTest = findViewById<TextView>(R.id.tv_test)
        tvTest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                LogUtil.d("view=${v}")
            }
        })

        tvTest2 = findViewById<TextView>(R.id.tv_test2)
        // 5.1.1作为函数参数的代码块
        tvTest2.setOnClickListener { Log.d("lipc0113", "view=${tvTest2}") }
    }

    fun initData() {
        val peoples = listOf(Person("lipc", 30), Person("syj", 28))
        // 5.1.2Lammbda与集合
        tvTest.setText(peoples.maxBy { it.age }?.name)
        tvTest2.setText(peoples.maxBy(Person::age)?.age.toString())
        LogUtil.d(peoples.maxBy { it.age }?.name.toString())
        LogUtil.d(peoples.maxBy(Person::age)?.age.toString())
    }
}
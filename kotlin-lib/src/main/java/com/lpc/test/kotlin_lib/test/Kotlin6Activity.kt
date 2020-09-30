package com.lpc.test.kotlin_lib.test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lpc.test.kotlin_lib.R
import com.lpc.test.kotlin_lib.test.utils.LogUtil

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:23 2020-01-15
 * @ Description：
 */
class Kotlin6Activity : AppCompatActivity() {

    var str: String? = null
    // 延迟初始化的属性lateinit
    lateinit var tv_test: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin6);
        initView()
        initData()
    }

    private fun initView() {

        tv_test = findViewById(R.id.tv_test);
    }

    private fun initData() {

        toString2(str)
//        toString3ForAny(str)

        if(str.isNullOrBlank()){
            LogUtil.d("可空类型的扩展：：str为空")
        }

//        printlnKotlin(str)
        LogUtil.d("let函数：：str?.let { str -> printlnKotlin(str) } = " + (str?.let { str -> printlnKotlin(str) }))

//        LogUtil.d("非空断言：：str!!.length = " + (str!!.length))

        LogUtil.d("Elvis运算符：：str as? Int = " + (str?.length ?: -1))

        LogUtil.d("安全调用：：str?.length = " + str?.length)
        str = "lpc";
        LogUtil.d("安全调用：：str?.length = " + str?.length)

        LogUtil.d("安全转换：：str as? Int = " + (str as? Int ?: return))
        LogUtil.d("安全转换：：str as? Any = " + (str as? Any))
    }

    private fun printlnKotlin(s: String) {
        println(s.length)
    }

    private fun <T> toString2(t: T) {
        LogUtil.d("类型参数的可空性：：" + t?.hashCode())
    }

    private fun <T : Any> toString3ForAny(t: T) {
        LogUtil.d("类型参数的可空性：：" + t?.hashCode())
    }
}
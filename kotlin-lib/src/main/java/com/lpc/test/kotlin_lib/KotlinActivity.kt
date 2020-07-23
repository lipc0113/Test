package com.lpc.test.kotlin_lib

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 10:23 2020-01-15
 * @ Description：
 */
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin);
        initView()
        initData()
    }

    fun initView(){
        val tvTest = findViewById<TextView>(R.id.tv_test)
        tvTest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("lipc0113", "view=${v}")
            }
        })

        val tvTest2 = findViewById<TextView>(R.id.tv_test2)
        tvTest2.setOnClickListener { Log.d("lipc0113", "view=${tvTest2}") }
    }

    fun initData(){

    }
}
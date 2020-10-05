package com.lpc.test.kotlin_lib.bean

/**
 * 功能:
 *
 *
 * 描述:
 *
 *
 * Created by lipc0113 on 2020/10/5.
 */
class Foo {
    var i: Int by Delegate()

    val emails by lazy {
        loadEmainls()
    }

    // 使用委托属性把值存到map中
    // map中的"key2"与属性key2必须是对应的。
    val map = mapOf("key2" to "value2", "key" to "value")
    val key: String by map
    val key2: String by map

    private fun loadEmainls(): Map<String, String> {
        return mapOf("1" to "1", "2" to "2")
    }

    override fun toString(): String {
        return "Foo()"
    }


}
package com.lpc.test.kotlin_lib.bean

import kotlin.reflect.KProperty

/**
 * 功能:
 *
 * 描述:
 *
 * Created by lipc0113 on 2020/10/5.
 */
class Delegate {
    private var i: Int = 0
    operator fun getValue(foo: Foo, property: KProperty<*>): Int = i

    operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {
        this.i = i + 10
    }
}
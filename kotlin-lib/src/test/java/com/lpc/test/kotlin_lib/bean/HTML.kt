package com.lpc.test.kotlin_lib.bean

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 15:42 2020/10/19
 * @ Description：html构建器
 */
class HTML {
    operator fun invoke(str:String){
        println("$str -> ${createHtml()}")
    }
}

open class TAG(val name: String) {

    private val children = mutableListOf<TAG>()

    // 这里的doInit相当于一个with函数
    protected fun <T : TAG> doInit(tag: T, init: T.() -> Unit) {
        tag.init()
        children.add(tag)
    }

    override fun toString(): String {
        return "<$name>${children.joinToString()}<$name>"
    }
}

class TABLE : TAG("table") {
    fun tr(init: TR.() -> Unit) {
        doInit(TR(), init)
    }
}

class TR : TAG("tr") {
    fun td(init: TD.() -> Unit) {
        doInit(TD(), init)
    }
}

class TD : TAG("td")

// 这里调用了一个apply函数
fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

//fun tr(init: TAG.() -> Unit){
//    TR().apply { init }
//}
//
//fun td(init: TAG.() -> Unit){
//    TABLE().apply { init }
//}

fun createHtml() = table {
    tr {
        td {

        }
    }
}
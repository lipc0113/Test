package com.lpc.test.kotlin_lib.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 12:47 2020-01-20
 * @ Description：
 */
class User1(_id: Int, _name: String) {
    val id: Int
    var name: String

    init {
        println("初始化...")
        id = _id
        name = _name
    }
}

class User2(_id: Int, _name: String) {
    val id = _id
    var name = _name
        private set

    init {
        println("初始化2...")
    }
}

open class User3(val id: Int, var name: String) {

    init {
        println("初始化3...")
    }
}

class User4 private constructor(val id: Int, var name: String) {

    init {
        println("初始化4...")
    }
}

open class User5() {

    var id: Int = 101

    var name: String = "lpc"

    constructor(_id: Int, _name: String) : this() {
        id = _id
        name = _name
    }

    init {
        println("初始化5...")
    }

    object MyComparator : Comparator<User5> {
        override fun compare(o1: User5?, o2: User5?): Int {
            if (o1 !is User5) {
                return -1
            }

            if (o2 !is User5) {
                return -1
            }
            if (o1.id == o2.id) {
                return o1.name.compareTo(o2.name)
            } else {
                return o1.id - o2.id
            }
        }
    }

    object MyFactory {
        fun getUser5() = User5(1100, "lpc")
    }

    companion object {
        val age = 80
        fun log() = "这是User5"
    }

    override fun toString(): String {
        return "${id},${name}"
    }
}

class User6 {

    open var id: Int = 101

    open var name: String = "lpc"

    constructor(_id: Int, _name: String) {
        id = _id
        name = _name
    }

    constructor(_id: Int) {
        id = _id
    }

    init {
        println("初始化6...")
    }
}

class User7() : User5() {

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()
    }

    constructor(_id: Int, _name: String) : this() {
        id = _id
        name = _name
    }

    constructor(_id: Int) : this(_id, "lpc") {
        id = _id
    }

    init {
        println("初始化7...")
    }
}
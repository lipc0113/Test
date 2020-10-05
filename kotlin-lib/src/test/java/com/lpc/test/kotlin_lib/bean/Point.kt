package com.lpc.test.kotlin_lib.bean

/**
 * plus +
 *
 * * times
 * / div
 * % mod
 * + plus
 * - minus
 *
 * */
class Point(val x: Int, val y: Int) : Comparable<Point> {





    operator fun inc(): Point {
        return Point(this.x + 1, this.y)
    }

    operator fun plus(str: String): String {
        return str
    }

    operator fun plus(otherX: Int): Point {
        return Point(this.x + otherX, this.y)
    }

    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }


    override fun toString(): String {
        return "x = " + x + ";y = " + y
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

//    override fun compareTo(other: Point): Int {
//
//        if (x != other.x) return x-other.x
//        if (y != other.y) return y-other.y
//
//        return 1
//    }

    override fun compareTo(other: Point): Int {

        return compareValuesBy(this, other, Point::x, Point::y)
    }

    operator fun component1(): Int = x

    operator fun component2(): Int = y
}
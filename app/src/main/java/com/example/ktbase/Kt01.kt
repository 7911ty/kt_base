package com.example.ktbase

class Kt01 {
    var  a = 19
}
var a = 10
fun main() {
    println("1")
    show(9)
    val minus = a.minus(1)
    val javaClass = a.javaClass
    println(javaClass)
    a++
    println(a++)
    println(++a)

}


fun show(number: Int): Unit {
    val i = when (number) {
        in 0..10 -> max(number, 10)
        else -> {
            println("wu")
        }
    }
    println(i)
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b

}

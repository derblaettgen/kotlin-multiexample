package com.multiexample

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"

var counter: Int = 0

fun raiseCounter() {
    counter++
}

fun receiveCounter(): Int {
    return counter
}
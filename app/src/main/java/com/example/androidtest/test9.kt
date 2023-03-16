package com.example.androidfirst

fun main() {
    var data: String = "hello"

    when(data){
        "hello" -> println("data is hello")
        "Hello" -> println("data is Hello")
        else -> println("data is not valid data")
    }
}
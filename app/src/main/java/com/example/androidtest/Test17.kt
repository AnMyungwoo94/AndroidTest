package com.example.androidfirst

fun main() {
    val myClass: MyClass = MyClass()
    println(MyClass.data)
    println(MyClass.some())
}

class MyClass constructor(){
    companion object{
        var data = 10
        fun some(){
            println("static member variable = ${MyClass.data}")
        }
    }
}
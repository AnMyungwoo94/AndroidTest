package com.example.androidfirst

val a51: Byte = 0b00001011
val a52 : Int = 123
val a53 : Short = 123
val a54: Long = 10L
val a56: Float = 10.0f
val a57 : Boolean = true
val a58 : Char = 'A'

fun main() {
    if(a58 == 'A'){
        println("true")
    }else{
        println("flase")
    }

    val str2 = """
        Hello
        World
    """
    println(str2)

    val str3 = "\t Hello \n \t world "
    println(str3)

}
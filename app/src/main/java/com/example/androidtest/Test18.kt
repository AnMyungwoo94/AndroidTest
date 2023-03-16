package com.example.androidfirs

//fun sum(no1: Int): Unit{
//
//    var no2 = 20
//    println("no1 = ${no1} no2 = ${no2}")
//    println("합계는 = ${no1+no2}")
//}


typealias MYFun = (Int) -> Unit
var sum: MYFun = {
    var no2 = 20
    println("no1 = ${it} no2 = ${no2}")
    println("합계는 = ${it + no2}")
}


//람다식으로 바꾸기
//fun sum(no1: Int, no2: Int): Int{
//    println("no1 = ${no1} no2 = ${no2}")
//    return no1 + no2
//}

//typealias  MyFun = (Int ,Int) -> Int
//val sum :MyFun ={ no1, no2 -> Int
//    println("no1 = ${no1} no2 = ${no2}")
//    no1 + no2
//}




fun sum(): Unit{
    var no2 = 20
    println("no1 =  no2 = ${no2}")
    println("합계는 = ${no2}")
}

fun addValue():Int {
    return 10+20
}

val addValue =  { ->
    10+20
}



fun main() {
    sum(10)
}
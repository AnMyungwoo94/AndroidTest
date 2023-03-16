package com.example.androidfirst

fun main() {
    var obj = Super1()
    obj.publicData++
   // obj.protectedData++


}

open class Super1 constructor(){
    public var publicData = 10
    protected var protectedData = 20
    private var privateData = 30
}
class Sub constructor(): Super1(){
    fun subFun(){
        publicData ++
        protectedData ++
       // privateData++
    }
}


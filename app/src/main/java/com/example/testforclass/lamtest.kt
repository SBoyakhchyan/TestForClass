package com.example.testforclass

//fun main() {
//
//    val lll = listOf(1, 5, 6, 6, 0, -5, -6, 89)
//    println(lll.customMap { it.toString() + "ss" })
//
//    println(lll.size.myTakeIf { it > 10 })
//    println(lll.myTakeIf { it.size > 10 })
//    lll.myTakeIf { it.contains(10) }
//
//    val name = "Baeldung"
//    val uppercase = name
//        .let { n -> n.uppercase() }
//    println(uppercase)
//
//
//}
//
//fun <T, R> List<T>.customMap(action: (T) -> R): List<R> {
//    val newList = mutableListOf<R>()
//    for (item in this) {
//        newList.add(action(item))
//    }
//    return newList
//}
//
//fun <T> T.myTakeIf(action: (T) -> Boolean): T? {
//    if (action(this)) {
//        return this
//    } else {
//        return null
//    }
//}

inline fun ordinaryFunction(block: () -> Unit) {
    println("hi!")
}

fun foo() {
    ordinaryFunction {
        return // ERROR: cannot make `foo` return here
    }
}

fun main() {
    foo()
}

inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
    }
    // ...
}

inline fun higherOrderFunction(crossinline aLambda: () -> Unit) {

    normalFunction {
        aLambda() //must mark aLambda as crossinline to use in this context.
    }

}

fun normalFunction(aLambda: () -> Unit) {

    return

}

fun callingFunction() {

    higherOrderFunction {

        return@higherOrderFunction  //Error. Can't return from here.
    }

}
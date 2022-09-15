package com.example.testforclass

import java.util.*

//fun main() {
//
//    val t = mapOf(
//        1 to "s",
//        2 to "s0",
//        3 to "ps",
//        1 to "r",
//        9 to "s",
//        null to "ss",
//        15 to null,
//        null to ""
//    )
//    println(t)
//    val y = hashMapOf(1 to "s", 2 to "s0", 3 to "ps", 1 to "r", 9 to "s", null to "", 15 to null)
//    println(y)
//    y.put(35, "lll")
//    y[25] = "hhh"
//    y.remove(null)
//    println(y)
//    val ages: Map<String?, Int?> = mapOf(
//        "Alice" to 25,
//        "Bob" to null,
//        "Charlie" to 30,
//        null to 2
//    )
//
//    val knownAges = ages.filterValues { it != null } as Map<String, Int>
//    println(knownAges)
//
//    val numbers: TreeMap<Int?, Int?> = TreeMap()
//    numbers[1] = 2
//    numbers[2] = 2
//    println(numbers)
//
////compareInts(6, 3){
////    println(it)
////}
//}
//
//inline fun compareInts(a: Int, b: Int,  crossinline compareResponse: (String) -> Unit) {
//    println("Set comparison")
//
//    val task = Runnable {
//        if (a > b) {
//            compareResponse("a > b")
//        } else if (a < b) {
//            compareResponse("a < b")
//        } else {
//            compareResponse("a == b")
//        }
//    }
//    task.run()
//    println("finished")
//}

fun main() {
    val b: Int? = 1
    val l = b?.toString() ?: "jhkj"

    println(l)
    val tom = Person("Tom")
    val bob = Employee("Bob", "JetBrains")

    checkEmployment(tom)    // Tom does not have a job
    checkEmployment(bob)    // Bob works in JetBrains
}

fun checkEmployment(person: Person){
    // println("${person.name} works in ${person.company}")    // Ошибка - у Person нет свойства company
    if(person is Employee){
        println("${person.name} works in ${person.company}")
    }
    else{
        println("${person.name} does not have a job")
    }
}
open class Person(val name: String)
class Employee(name: String, val company: String): Person(name)
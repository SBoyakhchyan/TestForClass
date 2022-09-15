package com.example.testforclass

fun main() {
    var myList = listOf(8, 1, -2, 5, 56, -5, -6, 45)
    var myLam: (List<Int>, Int) -> Int = { _, i -> i * 5 }

    fun List<Int>.myMap(action: (item: Int) -> Int): List<Int> {
        val emptyList = mutableListOf<Int>()
        for (i in this) {
            emptyList.add(action(i))
        }
        println(emptyList)
        return emptyList
    }
    myList.myMap { it * 5 }

    val myListNew: List<Int?> = listOf(null, 1, -2, 8, 56, -5, -6, 45, null)
    var myLamNew: (List<Int>, Int) -> Int = { _, i -> i }

    fun  List<Int?>.myMapNull(action: (item: Int) -> Int): List<Int> {
        val emptyListNull = mutableListOf<Int>()
        for (i in this) {
            if (i != null) {
                emptyListNull.add(action(i))
            }
        }
        println(emptyListNull)
        return emptyListNull
    }
    myListNew.myMapNull { it * it }
}
package com.example.testforclass

fun main() {

    val myLambda: (Int, Int) -> Int = { x, y -> (x + y) * 3 }

    fun addToNum(a: Int, b: Int, myFunc: (Int, Int) -> Int): Int {

        val result = myFunc(a, b)
        val new = result * 5
        return new

    }
    addToNum(5, 1, myLambda)


//var myMap = mapOf<Int, String>(1 to "s", 2 to "d", 3 to "r", 4 to "d", 5 to "r" )
//var myMap2 = mapOf<Int, String>(1 to "s", 2 to "d", 3 to "r", 4 to "d", 1 to "r" )
//    println(myMap)
//    println(myMap2)

    var myList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var myLam: (List<Int>, Int) -> Boolean = { list, element -> list.contains(element) }


    fun List<Int>.customFilter(action: (item: Int) -> Boolean): List<Int> {
        val emptyList = mutableListOf<Int>()
        this.forEach {
            if (!action(it)) {
                emptyList.add(it)
            }
        }
        println(emptyList)
        return emptyList
    }
    myList.customFilter{
        it > 9
    }

    val numbers: List<Int> = listOf(0, 1, 2, 3, 4, 8, 6)
    val numbersOnSameIndexAsValue = numbers.filterIndexed { index, i -> index == i }

}
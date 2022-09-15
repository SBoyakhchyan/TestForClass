package com.example.testforclass

fun main() {
    val colorsList = listOf("red", "brown", "grey", "black", "white", "black")
    val animalsList = listOf("fox", "bear", "wolf", "panter", "rabbit", "panter", "rabbit")
    println(colorsList zip animalsList)
    println(colorsList.zip(animalsList){ a , b ->
        "$a$b"
    })

//    /fun List<String>.myZip(
//        otherList: List<String>
//    ): List<Pair<String, String>> {
//        val zippedList = mutableListOf<Pair<String, String>>()
//
//    }
    colorsList.zip(animalsList).forEach {
        println(it)
    }

}

infix fun <T, R> Collection<T>.zip(Other: Collection<R>): Collection<Pair<T, R>> {
    val result = mutableListOf<Pair<T, R>>()
    for (keyIndex in this.indices) {
        if (keyIndex < Other.size) {
            result.add(Pair(this.elementAt(keyIndex), Other.elementAt(keyIndex)))
        } else {
            break
        }
    }
    return result
}


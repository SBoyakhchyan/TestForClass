package com.example.testforclass

fun main(){
    var myList = listOf(5,6,8,7,8,5,4,8,9,8,8)
    var myLam: (List<Int>, Int) -> Boolean = {list, i -> list.contains(i) }

    fun List<Int>.filterIndex(action: (index: Int) -> Boolean): List<Int>{
        val emptyList = mutableListOf<Int>()
        this.forEachIndexed { index, i ->
            if(action(index)){
                emptyList.add(i)
            }
        }
        println(emptyList)
        return emptyList
    }
    myList.filterIndex { it % 2 == 0 }
}
package com.example.testforclass

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    val countDownTimer = flow<Int> {
        val startValue = 10
        var currentValue = startValue
        emit(startValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }

    }
//init {
//    collectFlow()
//}
//    private fun collectFlow(){
//        viewModelScope.launch {
//            countDownTimer.collect()
//        }
//    }
}
package com.example.testforclass

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

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
        currentValue = startValue

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
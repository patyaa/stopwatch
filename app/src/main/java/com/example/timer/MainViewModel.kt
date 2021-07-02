package com.example.timer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val timer = MutableLiveData<String>("0")
    var job: Job? = null
    var timeCounter: Int = 0

    private suspend fun forever(action: suspend () -> Unit) {
        while (true) {
            action.invoke()
        }
    }

    fun stopTime() {
        job?.cancel()
    }

    fun startTime() {
        job = viewModelScope.launch {
            forever {
                updateTimer()
                delay(1000)
                timeCounter += 1
            }
        }
    }

    fun resetTime() {
        timeCounter = 0
        updateTimer()
    }

    private fun updateTimer(){
        timer.value = timeCounter.toString()
    }
}

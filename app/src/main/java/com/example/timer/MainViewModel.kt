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
    fun startTime() {
         job = viewModelScope.launch {
            repeat(10) {
                timer.value = it.toString()
                delay(1000)
            }
        }
    }

    fun stopTime() {
        job?.cancel()
    }

    fun resetTime(){
        timer.value = "0"
    }
}
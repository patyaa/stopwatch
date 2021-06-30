package com.example.timer
import android.os.SystemClock
import android.widget.Chronometer
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import kotlin.concurrent.timer

class MainViewModel : ViewModel(){

    private lateinit var ch: Chronometer
    init {
        //számláló elindítása
        startTime()
        //számláló megállítása
        stopTime()
        //számláló nullázása
        resetTime()
    }
    fun startTime() {
        ch.start()
    }

    fun stopTime() {
        ch.stop()
    }

    fun resetTime() {
        ch.base = SystemClock.elapsedRealtime()
    }
}
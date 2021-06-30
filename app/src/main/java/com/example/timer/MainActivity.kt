package com.example.timer

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.timer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()

    }
    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.timer,
            binding.start,
            binding.stop,
            binding.reset
        )
        for (item in clickableViews) {
            item.setOnClickListener { makeAction(it) }
        }
    }
    private fun makeAction(view: View) {
        when (view.id) {
            R.id.start -> {
                binding.timer.base = SystemClock.elapsedRealtime()
                binding.timer.start()
            }
            R.id.stop -> {
                binding.timer.stop()
                SystemClock.elapsedRealtime() - binding.timer.base
            }
            R.id.reset -> {
                binding.timer.base = SystemClock.elapsedRealtime()
            }
        }
    }
}
package com.example.timer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.timer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = setViewContent(this)

        binding.viewModel = viewModel
    }

    private fun setViewContent(activity: MainActivity): ActivityMainBinding {
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(activity, R.layout.activity_main)
        binding.lifecycleOwner = activity
        return binding
    }
}
package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.androidtest.databinding.ActivityMain4Binding
import com.example.androidtest.databinding.ActivityMain5Binding

class MainActivity4 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMain5Binding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnstart.setOnClickListener(this)
        binding.btnstop.setOnClickListener(this)
        binding.btnreset.setOnClickListener(this)
    }

    //SystemClock.elapsedRealtime() : 컴퓨터부팅부터 시작하여 경과된 시간
    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btnstart -> {
               binding.chronmeter.base = SystemClock.elapsedRealtime() + pauseTime
               binding.chronmeter.start()
               binding.btnstart.isEnabled = false
               binding.btnstop.isEnabled = true
               binding.btnreset.isEnabled = true
           }
           R.id.btnstop -> {
               pauseTime = binding.chronmeter.base -SystemClock.elapsedRealtime()
               binding.chronmeter.stop()
               binding.btnstart.isEnabled = true
               binding.btnstop.isEnabled = false
               binding.btnreset.isEnabled = true
           }
           R.id.btnreset -> {
               binding.chronmeter.base = SystemClock.elapsedRealtime()
               binding.chronmeter.stop()
               pauseTime = 0L
               binding.btnstart.isEnabled = true
               binding.btnstop.isEnabled = false
               binding.btnreset.isEnabled = false
           }
           else -> {}
       }
    }
}
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //첫번째 방법
//        binding.btnstart.setOnClickListener(this)
//        binding.btnstop.setOnClickListener(this)
//        binding.btnreset.setOnClickListener(this)


        //두번째 방법
//        binding.btnstart.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
//                binding.chronometer.start()
//                binding.btnstart.isEnabled = false
//                binding.btnstop.isEnabled = true
//                binding.btnreset.isEnabled = true
//            }
//        })
//        binding.btnstop.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                binding.btnstart.isEnabled = true
//                binding.btnstop.isEnabled = false
//                binding.btnreset.isEnabled = true
//            }
//        })
//        binding.btnreset.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                binding.chronometer.base = SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                pauseTime = 0L
//                binding.btnstart.isEnabled = true
//                binding.btnstop.isEnabled = false
//                binding.btnreset.isEnabled = false
//            }
//        })


        //세번째 방법
        binding.btnstart.setOnClickListener{v: View? ->
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnstart.isEnabled = false
                binding.btnstop.isEnabled = true
                binding.btnreset.isEnabled = true
            }

        binding.btnstop.setOnClickListener{v: View? ->
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnstart.isEnabled = true
                binding.btnstop.isEnabled = false
                binding.btnreset.isEnabled = true
            }

        binding.btnreset.setOnClickListener{v: View? ->
                binding.chronometer.base = SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                pauseTime = 0L
                binding.btnstart.isEnabled = true
                binding.btnstop.isEnabled = false
                binding.btnreset.isEnabled = false
            }
    }


    //첫번째 방법 위에 View.OnClickListener 선언해줘야함
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btnstart -> {
//                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
//                binding.chronometer.start()
//                binding.btnstart.isEnabled = false
//                binding.btnstop.isEnabled = true
//                binding.btnreset.isEnabled = true
//            }
//            R.id.btnstop -> {
//                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                binding.btnstart.isEnabled = true
//                binding.btnstop.isEnabled = false
//                binding.btnreset.isEnabled = true
//            }
//            R.id.btnreset -> {
//                binding.chronometer.base = SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                pauseTime = 0L
//                binding.btnstart.isEnabled = true
//                binding.btnstop.isEnabled = false
//                binding.btnreset.isEnabled = false
//            }
//        }
//    }
}
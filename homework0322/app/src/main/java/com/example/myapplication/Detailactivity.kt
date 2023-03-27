package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDetailactivityBinding

class Detailactivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
package com.example.homework0316

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework0316.databinding.ActivityMainBinding
import com.example.homework0316.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("msg")){
        binding.tvGetMsg.text = intent.getStringExtra("mag") // 서브액티비티에 존재하는 텍스트뷰에다가 헬로월드가 넘겨져옴

        }
    }
}
package com.example.homework0316

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework0316.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java) //다음 화면으로 이동하기 위한 인텐트 객체생성
            intent.putExtra("mag", binding.tvSendMsg.toString()) // 헬로우월드라는 텍스트값을 담은 뒤 msg라는 키로 잡았다.
            startActivity(intent) // 인텐트에 저장되어있는 엑티비티쪽으로 이동한다.

        }
    }
}
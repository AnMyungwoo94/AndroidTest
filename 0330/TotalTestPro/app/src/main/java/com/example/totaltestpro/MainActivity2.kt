package com.example.totaltestpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.totaltestpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //업버튼활성화 onSupportNavigateUp()없으면 뒤로 안감
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    //업버튼 돌아가기
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
package com.example.intentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentpro.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //값받기 -1은 아닐경우란 표시
       val x=  intent.getIntExtra("x", -1)
       val y=  intent.getIntExtra("y", -1)
       val operator =  intent.getStringExtra("operator")
        //잘되었는지 확인
        var sum = 0
        when(operator){
           "+" -> sum = x+y
           "-" -> sum = x-y
           "*" -> sum = x*y
           "%" -> sum = x%y
        }
        binding.btnReturnActivity.setOnClickListener {
            intent.putExtra("sum", sum)
            //startActivity와 똑같은 역할 (RESULT_OK , no 둘중 고르기)
            setResult(RESULT_OK, intent)
            // 자기창 죽이기
            finish()
        }
    }
}
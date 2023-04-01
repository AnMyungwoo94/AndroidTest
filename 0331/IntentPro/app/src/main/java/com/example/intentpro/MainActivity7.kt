package com.example.intentpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentpro.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val x = intent.getIntExtra("x", -1)
        val y = intent.getIntExtra("y", -1)
        val operator = intent.getStringExtra("operator")
        //잘되었는지 확인
        var sum = 0
        when (operator) {
            "+" -> sum = x + y
            "-" -> sum = x - y
            "*" -> sum = x * y
            "%" -> sum = x % y
        }
        binding.tvX1.text = x.toString()
        binding.tvY1.text = y.toString()
        binding.tvsum1.text = sum.toString()

        binding.btnReturnMain1.setOnClickListener {
            intent.putExtra("sum", sum)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
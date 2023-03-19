package com.example.homework0316

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework0316.databinding.ActivityMain2Binding
import com.example.homework0316.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            binding.imageView.setImageResource(R.drawable.image1)
            Toast.makeText(this@MainActivity2, "버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show()
        }

    }
}
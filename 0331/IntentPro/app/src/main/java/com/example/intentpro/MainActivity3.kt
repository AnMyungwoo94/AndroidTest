package com.example.intentpro

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentpro.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = this.intent.getStringExtra("name")
        val age = this.intent.getIntExtra("age", 10)

        binding.ivPicture2.setOnClickListener {
            Toast.makeText(applicationContext, "${name} ${age}", Toast.LENGTH_SHORT).show()
        }
    }
}
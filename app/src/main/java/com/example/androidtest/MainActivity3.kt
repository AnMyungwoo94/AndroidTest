package com.example.androidtest

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.example.androidtest.databinding.ActivityMain3Binding
import com.example.androidtest.databinding.ActivityMain4Binding

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick1.setOnClickListener(this)
        binding.btnClick2.setOnClickListener(this)
        binding.btnClick3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,"체크박스 3번", Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnClick4.setOnClickListener{v: View? ->
                Toast.makeText(applicationContext,"체크박스 4번", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnClick1-> {
                Toast.makeText(applicationContext, "체크박스 1번", Toast.LENGTH_SHORT).show()
            }
            R.id.btnClick2-> {
                Toast.makeText(applicationContext, "체크박스 2번", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.androidtest.databinding.*

class MainActivity : AppCompatActivity() {
    lateinit var binding2: ActivitySub11Binding
    lateinit var binding3: ActivitySub13Binding
    lateinit var binding4: ActivitySub12Binding
    lateinit var binding5: ActivitySub15Binding
    lateinit var binding6: ActivitySub16Binding
    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivitySub11Binding.inflate(layoutInflater)
        binding3 = ActivitySub13Binding.inflate(layoutInflater)
        binding4 = ActivitySub12Binding.inflate(layoutInflater)
        binding5 = ActivitySub15Binding.inflate(layoutInflater)
        binding6 = ActivitySub16Binding.inflate(layoutInflater)
        setContentView(binding6.root)

//        binding6.tvLongClick.setOnClickListener {
//            Toast.makeText(applicationContext,binding6.edtPassword.text.toString(),Toast.LENGTH_SHORT).show()
//        }

        binding6.tvLongClick.setOnLongClickListener {

            binding6.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            Toast.makeText(applicationContext, binding6.edtPassword.text.toString(), Toast.LENGTH_SHORT).show()

            return@setOnLongClickListener (true)
        }
        binding6.tvLongClick.setOnClickListener {
            binding6.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

//        binding3.btn10.setOnClickListener {
//            if(flag==true){
//                binding3.btn10.visibility = View.VISIBLE
//                binding3.btn17.visibility = View.VISIBLE
//                flag = false
//            }else{
//                binding3.btn11.visibility = View.INVISIBLE
//                binding3.btn17.visibility = View.GONE
//                flag = true
//            }
//        }
//
//
    }
}
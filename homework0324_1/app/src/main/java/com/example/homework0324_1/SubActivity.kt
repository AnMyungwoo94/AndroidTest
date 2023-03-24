package com.example.homework0324_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework0324_1.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            to1.text = intent.getStringExtra("from1")
            to2.text = "${intent.getIntExtra("from2",0)}"

            btnClose.setOnClickListener {
                val returnIntent = Intent()
                val message = editMessage.text.toString()
                returnIntent.putExtra("returnValue", message)
                setResult(RESULT_OK,  returnIntent)
                finish()
            }

        }


    }
}
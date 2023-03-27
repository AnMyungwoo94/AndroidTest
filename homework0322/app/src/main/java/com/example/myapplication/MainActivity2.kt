package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowMetrics
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.delayTextView.setOnClickListener { v: View? ->
            binding.mainTextView.text = getString(R.string.main_button)
            binding.delayTextView.setTextColor(ResourcesCompat.getColor(resources, R.color.text_color2, null))
            Log.e("MainActivity2", getString(R.string.main_button))
            Toast.makeText(this, "텍스트 클릭!", Toast.LENGTH_SHORT).show()
        }

        binding.delayButtonView.setOnClickListener { v: View? ->
            binding.mainTextView.text = getString(R.string.main_sub_button)
            binding.delayButtonView.setTextColor(ResourcesCompat.getColor(resources, R.color.text_color2, null))
            Log.e("MainActivity2",  getString(R.string.main_sub_button))
            Toast.makeText(this, "버튼 클릭!", Toast.LENGTH_SHORT).show()
        }


        //화면정보를 가져오는데 버전에따라서 명령이 틀린다. API 30 버전
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics
            Log.e("MainActivity2", "width 30이상 : ${windowMetrics.bounds.width()}" +
                    "height : ${windowMetrics.bounds.height()}")
        }else{
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            Log.e("MainActivity2", "width 30미만 : ${displayMetrics.widthPixels}" +
                    "height : ${displayMetrics.heightPixels}")
        }
    }//end of onCreate
}
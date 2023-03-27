package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var pauseTime = 0L
    var initTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnstart.setOnClickListener { v: View? ->
 //         binding.tvMessge.text = getString(R.string.btn_start)
//            binding.tvMessge.textSize = resources.getDimension(R.dimen.txt_size_large)
//            binding.tvMessge.setTextColor(ResourcesCompat.getColor(resources, R.color.text_color2, null))
//            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
//            binding.chronometer.start()
//            binding.btnstart.isEnabled = false
//            binding.btnstop.isEnabled = true
//            binding.btnreset.isEnabled = true
//        }
//
//        binding.btnstop.setOnClickListener { v: View? ->
//            binding.tvMessge.text = getString(R.string.btn_stop)
//            binding.tvMessge.textSize = resources.getDimension(R.dimen.txt_size_small)
//            binding.tvMessge.setTextColor(ResourcesCompat.getColor(resources, R.color.text_color, null))
//            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
//            binding.chronometer.stop()
//            binding.btnstart.isEnabled = true
//            binding.btnstop.isEnabled = false
//            binding.btnreset.isEnabled = true
//        }
//
//        binding.btnreset.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                binding.tvMessge.textSize = resources.getDimension(R.dimen.txt_size_medium)
//                binding.tvMessge.text = getString(R.string.btn_reset)
//                binding.chronometer.base = SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                pauseTime = 0L
//                binding.btnstart.isEnabled = true
//                binding.btnstop.isEnabled = false
//                binding.btnreset.isEnabled = false
            }
//        })
//    }

    //백버튼을 가져오려고 한다. (볼륨조절, 정원, 백버튼, 키보드(아이크림샌드위치))
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if(System.currentTimeMillis() - initTime > 3000){
//                Toast.makeText(this@MainActivity, "종료하려면 3초이내에 한번 더 눌러주세요", Toast.LENGTH_SHORT).show()
//                initTime = System.currentTimeMillis()
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }

//    override fun onBackPressed() {
//        if (System.currentTimeMillis() - initTime > 3000) {
//            binding.tvMessge.text = getString(R.string.btn_back)
//            Toast.makeText(this@MainActivity, getString(R.string.btn_back), Toast.LENGTH_SHORT).show()
//            initTime = System.currentTimeMillis()
//        } else {
//            super.onBackPressed()
//        }
//    }
}


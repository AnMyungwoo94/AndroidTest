package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import com.example.androidtest.databinding.ActivityMain3Binding

class MainActivity2 : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ckbClick.setOnCheckedChangeListener(this)
        binding.ckbClick2.setOnCheckedChangeListener(this)
        binding.ckbClick3.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Toast.makeText(applicationContext, "3번 버튼클릭", Toast.LENGTH_SHORT).show()
            }
        })
        binding.ckbClick4.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(applicationContext, "4번 버튼클릭", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.ckbClick -> {
                Toast.makeText(applicationContext, "체크박스 1번", Toast.LENGTH_SHORT).show()
            }
            R.id.ckbClick2 -> {
                Toast.makeText(applicationContext, "체크박스 2번", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

//    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//        when (buttonView?.id) {
//            R.id.ckbClick -> {
//                Toast.makeText(applicationContext, "체크박스 1번", Toast.LENGTH_SHORT).show()
//            }
//            R.id.ckbClick2 -> {
//                Toast.makeText(applicationContext, "체크박스 2번", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}

//    class A : CompoundButton.OnCheckedChangeListener {
//        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//            if (isChecked) {
//                Log.e(" MainActivity2", "체크했어요")
//            } else {
//                Log.e(" MainActivity2", "체크해제했어요")
//            }
//        }
//    }


//콜백함수 재정의(빽버튼만 인식)
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        when(keyCode){
////          KeyEvent.KEYCODE_BACK -> Log.e("MainActivity2","백버튼 눌렀습니다.")
//            KeyEvent.KEYCODE_VOLUME_UP -> Log.e("MainActivity2","볼륨업을 눌렀습니다.")
//            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.e("MainActivity2","볼륨다운을 눌렀습니다.")
//        }
//        return super.onKeyDown(keyCode, event)
//    }
//
//    //콜백함수 재정의 빽버튼만 받는다
//    override fun onBackPressed() {
//        Toast.makeText(this,"빽버튼을 클릭했습니다.", Toast.LENGTH_SHORT).show()
//        //빽버튼역할을 수행함(없으면 앱 안나가져
//        super.onBackPressed()
//    }





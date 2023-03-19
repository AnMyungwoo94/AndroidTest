package com.example.homework03165

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework03165.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) { // 해당 액티비티가 처음 실행될 때 한번 수행하는 곳
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //todo : 저장된 데이터를 로드
        lodeData() //edit 텍스트에 저장되어있던 값을 셋 텍스트
    }

    private fun lodeData() {
        val pref = getSharedPreferences("pref",0)
        binding.etHello.setText(pref.getString("name","")) // 1번째 인자에서는 저장할 당시의 키 값을 적어줌, 2번쨰 키 값에 데이터가 존재하지 않을경우 대체 값을 적어줌
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref",0)
        val edit = pref.edit() // 수정모드
        edit.putString("name", binding.etHello.text.toString() ) // 1번째 인자에는 키 값을, 2번째 인자에는 실제 담아둘 값을 저장
        edit.apply() // 값을 저장완료
    }

    override fun onDestroy() { // 해당 액티비티가 종료되는 시점이 다가올 때 호출
        super.onDestroy()
        saveData() //edit 텍스트값을 저장
    }

}
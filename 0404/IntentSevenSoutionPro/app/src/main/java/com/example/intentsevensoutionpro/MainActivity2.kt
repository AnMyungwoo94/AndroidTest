package com.example.intentsevensoutionpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentsevensoutionpro.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //1단계 액티비티전환
        //2단계 데이타 받기 id, pwd
        if (intent.hasExtra("no")) {
            when (intent.getIntExtra("no", 0)) {
                //2단계 데이타보내기
                0 -> {
                    if (intent.hasExtra("id").equals("") && intent.hasExtra("pwd").equals("")) {
                        Toast.makeText(this, "아이디와 패스워드가 없습니다.", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        val id = intent.getStringExtra("id")
                        val pwd = intent.getStringExtra("pwd")
                        Toast.makeText(this, "${id}와 ${pwd}가 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                //3단계 데이타 객체로 보내기
                3 -> {
                    val LoginData = intent.getSerializableExtra("loginData") as LoginData
                    Toast.makeText(
                        this,
                        "${LoginData.id}와 ${LoginData.pwd}가 있습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                4 -> {
                    val loginDataParcel =
                        intent.getParcelableExtra<LoginDateParcel>("loginDataParcel")
                    Toast.makeText(
                        this,
                        "${loginDataParcel?.id}와 ${loginDataParcel?.pwd}가 있습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                5 -> {
                    val loginDataParcelList =
                        intent.getParcelableArrayListExtra<LoginDateParcel>("loginDataParcelList")
                    Toast.makeText(
                        this,
                        "${loginDataParcelList?.get(2)?.id}와 ${loginDataParcelList?.get(2)?.pwd}가 있습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }//end of oncreate
        }
    }
}
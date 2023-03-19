package com.example.homework03168

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework03168.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileList = arrayListOf(
           Profiles(R.drawable.man,"안명우",30,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"이상윤",20,"웹 개발자"),
            Profiles(R.drawable.man,"김민철",19,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"이홍수",45,"데이터베이스 개발자"),
            Profiles(R.drawable.man,"김나연",80,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"김승연",60,"웹 개발자"),
            Profiles(R.drawable.man,"이채연",75,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"정혜민",10,"안드로이드 앱 개발자"),
            Profiles(R.drawable.man,"윤나의",24,"데이터베이스 개발자"),
            Profiles(R.drawable.woman,"김수아",26,"안드로이드 앱 개발자"),
            Profiles(R.drawable.man,"정주아",23,"데이터베이스 개발자"),
        )
        binding.rvProfile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)

        binding.rvProfile.adapter = ProfileAdapter(profileList)
    }


}
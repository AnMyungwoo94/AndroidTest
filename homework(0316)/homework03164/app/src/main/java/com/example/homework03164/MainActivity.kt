package com.example.homework03164

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.homework03164.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START) // start : left , end : right 랑 같은말
        }

        binding.naviView.setNavigationItemSelectedListener (this) //네비게이션 메뉴 아이템에 클릭 속성을 부여

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네이케이션 메뉴 아이템 클릭시 수행
       when(item.itemId){
           R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
           R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
           R.id.messge -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()

       }
        binding.layoutDrawer.closeDrawers() // 네이게이션 뷰 담기기
        return false
   }

    override fun onBackPressed() { //빽버튼 누를시 수행하는 메소드

        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()
        }else{
            super.onBackPressed()
        }
    }
}
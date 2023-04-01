package com.example.appbarpro

import OneFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appbarpro.databinding.ActivityMainBinding
import com.example.appbarpro.databinding.UsertabButtonBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var customViewpagerAdapterAdapter: CustomViewpagerAdapterAdapter
    lateinit var tabTitleList : MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //리사이클러뷰 어댑터
        customViewpagerAdapterAdapter = CustomViewpagerAdapterAdapter(this)
        customViewpagerAdapterAdapter.addListFragment(OneFragment())
        customViewpagerAdapterAdapter.addListFragment(TwoFragment())
        customViewpagerAdapterAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("자동차", "하우스", "비행기")
        binding.viewPager2.adapter = customViewpagerAdapterAdapter

        //탭레이아웃 뷰페이저 연동
        TabLayoutMediator(binding.tablayout, binding.viewPager2){ tab, position ->
            //tab.text = tabTitleList.get(positin)
            tab.setCustomView(tabCustomView(position))
        }.attach()

        binding.eftb.setOnClickListener {
            Toast.makeText(applicationContext, "확장탭이다", Toast.LENGTH_SHORT).show()
        }
    }
    fun tabCustomView(position : Int) : View {
        val binding = UsertabButtonBinding.inflate(layoutInflater)
        when(position){
            0 ->  binding.ivIcon.setImageResource(R.drawable.car_24)
            1 ->  binding.ivIcon.setImageResource(R.drawable.baseline_warehouse_24)
            2 ->  binding.ivIcon.setImageResource(R.drawable.baseline_connecting_airports_24)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }
}
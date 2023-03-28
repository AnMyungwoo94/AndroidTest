package com.example.activitylifecyclepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.activitylifecyclepro.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var oneFragment: OneFragment
    lateinit var twoFragment: TwoFragment
    lateinit var threeFragment: ThreeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        oneFragment = OneFragment()
        twoFragment = TwoFragment()
        threeFragment = ThreeFragment()

        //1. 탭레이아웃에 탭메뉴를 추가한다.
        val tab1: TabLayout.Tab = binding.tabLayout.newTab()
        val tab2: TabLayout.Tab = binding.tabLayout.newTab()
        val tab3: TabLayout.Tab = binding.tabLayout.newTab()
        //1-1 이름주기
        tab1.text = "FRAG1"
        tab2.text = "FRAG2"
        tab3.text = "FRAG3"
        //1-2탭에 넣어주기
        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addTab(tab3)

        //2.탭레이아웃 이벤트처리
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab?.text) {
                    "FRAG1" -> changeFragment("FRAG1",null)
                    "FRAG2" -> changeFragment("FRAG2",null)
                    "FRAG3" -> changeFragment("FRAG3",null)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    fun changeFragment(tabName: String, data: String?) {
        val transaction = supportFragmentManager.beginTransaction()
        val bundle = Bundle()

        bundle.putString("name", data)
        when (tabName) {
            "FRAG1" -> {
                val tab= binding.tabLayout.getTabAt(0)
                binding.tabLayout.selectTab(tab)
                oneFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, oneFragment)
            }
            "FRAG2" -> {
                val tab= binding.tabLayout.getTabAt(1)
                binding.tabLayout.selectTab(tab)
                twoFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, twoFragment)
            }
            "FRAG3" -> {
                val tab= binding.tabLayout.getTabAt(2)
                binding.tabLayout.selectTab(tab)
                threeFragment.arguments = bundle
                transaction.replace(R.id.frameLayout, threeFragment)
            }
        }
        transaction.commit()
    }
}


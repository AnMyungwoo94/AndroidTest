package com.example.homework0324_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework0324_6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. 페이지 데이터를 로드
        val list = listOf(BlankFragmentA(), BlankFragmentB(), BlankFragmentC(), BlankFragmentD())
        //2. 아답터를 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)
        //3. 아탑터와 뷰페이져 연결
        binding.viewPager.adapter = pagerAdapter

        //4. 탭 메뉴의 개수만큼 제목을 목록으로 생성
        val titles = listOf("A","B","C","D")

        //5. 탭레이아웃과 뷰 페이저 연결
        TabLayoutMediator(binding.tabLauout, binding.viewPager){ tab, position ->
            tab.text = titles.get(position)
        }.attach()
    }
}
class FragmentPagerAdapter(val fragmentList:List<Fragment>, fragmentActivity: FragmentActivity)
    : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList.get(position)
    }

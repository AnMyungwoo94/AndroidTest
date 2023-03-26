package com.example.homework0324_8

import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework0324_8.databinding.ActivityMainBinding
import com.example.homework0324_8.databinding.ItemViewpagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //1. 데이터를 로드
        val list = loadData()
        //2. 아답터를 생성
        val pagerAdapter = CustomPagerAdapter(list)
        //3.아탑터와 뷰페이저를 연결
        binding.viewPager.adapter = pagerAdapter
        //4.  타이틀 목록 생성 - 위의 데이터 사용
        val titles = listOf("월", "화", "수", "목", "금", "토", "일")
        //5. 탭 레이아웃과 뷰페이지 연결
        TabLayoutMediator(binding.tabLauout, binding.viewPager) { tab, position ->
            tab.text = titles.get(position)
        }.attach()
    }

    fun loadData(): List<Page> {
        val pageList = mutableListOf<Page>()
        pageList.add(Page(1, "흐림"))
        pageList.add(Page(2, "맑음"))
        pageList.add(Page(3, "구름"))
        pageList.add(Page(4, "비"))
        pageList.add(Page(5, "눈"))
        pageList.add(Page(6, "태풍"))
        pageList.add(Page(7, "안개"))
        return  pageList
    }
}
class CustomPagerAdapter(val pageList: List<Page>) :
    RecyclerView.Adapter<CustomPagerAdapter.Holder>() {

    class Holder(val binding: ItemViewpagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setItem(page: Page) {
            with(binding){
                textDay.text = "${page.day}일"
                textWeather.text = page.weather
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = pageList.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setItem(pageList.get(position))
    }
}
data class Page(val day: Int, val weather: String)
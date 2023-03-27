package com.example.day0327

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day0327.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindging : ActivityMainBinding
    lateinit var datalist: MutableList<DataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindging.root)

        //1. 데이타 리스트를 만들어서 어댑터에 제공
        datalist = mutableListOf<DataList>()
        for(i in 1..30){
            if(i % 2 == 0){
                datalist.add(DataList("홍길동${i}", "${20 +i}세", "rlaed${i}@naver.com",R.drawable.ironman))
            }else{
                datalist.add(DataList("홍길녀${i}", "${20+i}세", "rlaed${i}@naver.com",R.drawable.wonderwoman))
            }
        }//for
        //2. 커스텀어댑터에 데이타리스트를 제공
        val customAdapter = CustomAdapter(datalist)
        //3. 리사이클러뷰에 적용시킨다.
        bindging.recyclerView.adapter = customAdapter
        //4. 레이아웃 매니저를 통해서 리사이클러뷰의 방향을 설정한다.
        //val layoutManager =  GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
        val layoutManager =  LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        bindging.recyclerView.layoutManager = layoutManager
    }//oncreate
}
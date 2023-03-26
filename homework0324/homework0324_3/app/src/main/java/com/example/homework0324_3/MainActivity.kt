package com.example.homework0324_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework0324_3.databinding.ActivityMainBinding
import com.example.homework0324_3.databinding.ItemRecylerviewBinding
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 데이터를 불러온다.
        val data = loadData()
        //2. 아탑터를 생성
        val customAdapter = CustomAdapter(data)
        //3. 화면의 리사이클러뷰와 연결
        binding.recyclerView.adapter = customAdapter
        //4. 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


    }
    //1. item_recylerview를 만든다.
    //2. Memo 파일을 만든다. 데이터의 패턴에 맞게 데이타클래스를 정의해서 사용한다.
    //3. 메인엑티비에서 Memo파일을 정의한다.

    fun loadData(): MutableList<Memo>{
        val memolist = mutableListOf<Memo>()
        //100개의 메모 클래스를 넘겨받을 수 있다.
        for(no in 1..100){
            val title = "이것이 안드로이드다 $no"
            val date = System.currentTimeMillis()
            val memo = Memo(no,title, date)
            memolist.add(memo)
        }
        return memolist
    }
}

class CustomAdapter(val listData:MutableList<Memo>) : RecyclerView.Adapter<CustomAdapter.Holder>(){

    //화면에 뿌려줄 아이템을 생성함
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecylerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //1. 사용할 데이터를 꺼내고
        var memo = listData.get(position)
        //2. 홀더에 데이터를 전달
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class Holder(var binding:ItemRecylerviewBinding):RecyclerView.ViewHolder(binding.root){
        lateinit var currentMemo:Memo
        //클릭처리는 init에서만 한다.
        init{
            binding.root.setOnClickListener{
                Toast.makeText(binding.root.context,"클린된 아이템 : ${currentMemo.title}", Toast.LENGTH_SHORT).show()
            }
        }
        //3. 받은 데이터를 화면서 출력한다.
        fun setMemo(memo:Memo){
            currentMemo = memo
            with(binding){
            textNo.text = "${memo.no}"
            textTitle.text = memo.title

            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val formattedDate = sdf.format(memo.timestamp)
            textDate.text = formattedDate
            }
        }
    }
}
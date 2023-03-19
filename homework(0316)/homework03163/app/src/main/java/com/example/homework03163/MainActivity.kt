package com.example.homework03163

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.homework03163.databinding.ActivityMainBinding
import com.example.homework03163.databinding.ListItemUserBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var UserList = arrayListOf<User>(
        User(R.drawable.flower,"안명우","30","안녕하세요"),
        User(R.drawable.flower,"이지은","28","반갑습니다"),
        User(R.drawable.flower,"안진솔","20","행복하세요"),
        User(R.drawable.flower,"김빛나","40","또 만나요"),
        User(R.drawable.flower,"성주환","25","보고싶어요"),
        User(R.drawable.flower,"이주연","15","놀고싶어요"),
        User(R.drawable.flower,"유민기","45","성공하세요"),
        User(R.drawable.flower,"주한나","22","즐거웠어요"),
        User(R.drawable.flower,"박나래","26","감동이네요"),
        User(R.drawable.flower,"김민아","27","흥미롭네요")
   )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val item = arrayOf("사과", "배", "딸기", "키위","포도")
//        //context란 한 액티비티의 정보를 담고있음
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, item)

        val Adapter = UesrAdapter(this,UserList)
        binding.listView.adapter = Adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}
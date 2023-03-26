package com.example.homework0324_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BulletSpan
import androidx.fragment.app.ListFragment
import com.example.homework0324_4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val listkFragment = ListkFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()


        binding.btnSend.setOnClickListener {
           listkFragment.setValue("값 전달하기")
        }
    }

    fun goDetil(){
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack(){
        onBackPressed()
    }

    fun setFragment(){

        val bundle = Bundle()
        bundle.putString("key1", "List fragment")
        bundle.putInt("key2", 20230325)
        listkFragment.arguments = bundle

        //2. 트랙잭션 생성
        val transaction = supportFragmentManager.beginTransaction()
        //3. 트랜잭션을 통해 프래그먼트 삽입
        transaction.add(R.id.frameLayout, listkFragment)
        transaction.commit()
    }
}
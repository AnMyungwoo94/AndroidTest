package com.example.intentpro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //값을 주기만하기
        binding.btnCallActivity2.setOnClickListener {
            // this가 , MainActivity2를 부를거야 /명시적 인텐트
            val intent: Intent =  Intent(this, MainActivity2 ::class.java)
            //인텐트의 번들 값보내기
            intent.putExtra("name","홍길동")
            intent.putExtra("age", 27)
            //안드로이드시스템에 전달해줘, 값 주기만한다. 주고받는거 안됨
            startActivity(intent)
         }
        //내가 혼자함
        binding.btnCallActivity3.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("name" ,"홍길동")
            intent.putExtra("age" ,27)
            startActivity(intent)
        }

        //값을 주고 받기 onActivityResult필요
        binding.btnCallActivity4.setOnClickListener {
            //명시적 인텐트
            // this가 , MainActivity2를 부를거야
            val intent: Intent =  Intent(this, MainActivity4 ::class.java)
            //인텐트의 번들 값보내기
            intent.putExtra("x",45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            //리퀘스트코드 내 맘대로정함,
            startActivityForResult(intent, 20)


        }

        binding.btnCallActivity5.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("x", 30)
            intent.putExtra("y", 150)
            intent.putExtra("operator", "-")
            startActivityForResult(intent, 100)
        }

        //한번에 할수있음
        val activityResultLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            //콜백함수
                if(it.data?.getIntExtra ("requestCode",0 )== 100) {
                    //결과값찍기
                    Toast.makeText(applicationContext, "${it.data?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show()
                }
        }
        binding.btnCallActivity6.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("x",45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "+")
            intent.putExtra("requestCode", 60)
            activityResultLauncher.launch(intent)
        }

        binding.btnCallActivity7.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            intent.putExtra("x",45)
            intent.putExtra("y", 23)
            intent.putExtra("operator", "*")
            intent.putExtra("requestCode", 100)
            activityResultLauncher.launch(intent)
        }

    } // end of oncreate

    //잘 되돌아왔는지 확인(10, ok혹은 no, 값)
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if(requestCode == 20 && resultCode == RESULT_OK) {
            //결과값찍기
            Toast.makeText(applicationContext,
                "${intent?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show()
        }
//        }else if(requestCode == 100 && resultCode == RESULT_OK){
//            Toast.makeText(applicationContext, "${intent?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show()
//        }else if(requestCode == 60 && resultCode == RESULT_OK){
//            Toast.makeText(applicationContext, "${intent?.getIntExtra("sum", 0)}", Toast.LENGTH_SHORT).show()
//        }
//        else{
//            Toast.makeText(applicationContext, "계산결과가 잘못되었어요", Toast.LENGTH_SHORT).show()
//        }
    }
}
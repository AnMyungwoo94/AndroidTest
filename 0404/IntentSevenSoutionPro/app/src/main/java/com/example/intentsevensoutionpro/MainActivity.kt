package com.example.intentsevensoutionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intentsevensoutionpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCallActivity.setOnClickListener(this)
        binding.btnSendData.setOnClickListener(this)
        binding.btnSendDataObject.setOnClickListener(this)
        binding.btnSendParcelObject2.setOnClickListener(this)
        binding.btnSendParcelArrayList.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btnCallActivity ->{
               val intent = Intent(this, MainActivity2::class.java)
               startActivity(intent)
           }
           R.id.btnSendData ->{
               val intent = Intent(this, MainActivity2::class.java)
               intent.putExtra("id","admin")
               intent.putExtra("pwd","123456")
               startActivity(intent)
           }
           R.id.btnSendDataObject->{
               val intent = Intent(this, MainActivity2::class.java)
               val loginData = LoginData("admin", "123456")
               intent.putExtra("no",3)
               intent.putExtra("loginData", loginData)
               startActivity(intent)
           }
           R.id.btnSendParcelObject2->{
               val intent = Intent(this, MainActivity2::class.java)
               val loginDataParcel = LoginDateParcel("admin", "123456")
               intent.putExtra("no",4)
               intent.putExtra("loginDataParcel", loginDataParcel)
               startActivity(intent)
           }
           R.id.btnSendParcelArrayList->{
               val intent = Intent(this, MainActivity2::class.java)
               val loginDateParcelList = arrayListOf<LoginDateParcel>()
               loginDateParcelList.add(LoginDateParcel("admin", "123456-1"))
               loginDateParcelList.add(LoginDateParcel("admin1", "123456-2"))
               loginDateParcelList.add(LoginDateParcel("admin2", "123456-3"))
               loginDateParcelList.add(LoginDateParcel("admin3", "123456-4"))
               loginDateParcelList.add(LoginDateParcel("admin4", "123456-5"))
               intent.putExtra("no",5)
               intent.putExtra("loginDataParcelList", loginDateParcelList)
               startActivity(intent)
           }
       }
    }
}
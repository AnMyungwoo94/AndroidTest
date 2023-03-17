package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.androidtest.databinding.*

class MainActivity : AppCompatActivity() {
    lateinit var binding2: ActivitySub11Binding
    lateinit var binding3: ActivitySub13Binding
    lateinit var binding4: ActivitySub12Binding
    lateinit var binding5: ActivitySub15Binding
    lateinit var binding6: ActivitySub16Binding
    lateinit var binding7: ActivitySub20Binding
    lateinit var binding8: ActivitySub23Binding

    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivitySub11Binding.inflate(layoutInflater)
        binding3 = ActivitySub13Binding.inflate(layoutInflater)
        binding4 = ActivitySub12Binding.inflate(layoutInflater)
        binding5 = ActivitySub15Binding.inflate(layoutInflater)
        binding6 = ActivitySub16Binding.inflate(layoutInflater)
        binding7 = ActivitySub20Binding.inflate(layoutInflater)
        binding8 = ActivitySub23Binding.inflate(layoutInflater)

        setContentView(binding8.root)

        binding8.btnSelectOne.setOnClickListener {
            if (flag == true) {
                binding8.screenOne.visibility = View.VISIBLE
                binding8.screenTwo.visibility = View.INVISIBLE
                flag = false
            } else {
                binding8.btnSelectTwo.setOnClickListener {
                    binding8.screenOne.visibility = View.INVISIBLE
                    binding8.screenTwo.visibility = View.VISIBLE
                    flag = true
                }
            }
        }



//        binding8.btnSelectOne.setOnClickListener{
//            binding8.screenOne.visibility = View.VISIBLE
//            binding8.screenTwo.visibility = View.INVISIBLE
//         }
//        binding8.btnSelectTwo.setOnClickListener{
//            binding8.screenOne.visibility = View.INVISIBLE
//            binding8.screenTwo.visibility = View.VISIBLE
//        }

        //FrameLayout -> LinerLayout 1번화면
        binding8.imgPictureOne.setOnClickListener {
            Toast.makeText(this,"1번 화면입니다.", Toast.LENGTH_SHORT).show()
        }
        //FrameLayout -> LinerLayout 2번화면
        binding8.imgPictureTwo.setOnClickListener {
            Toast.makeText(this,"2번 화면입니다.", Toast.LENGTH_SHORT).show()
        }






        binding7.checkBox3.isChecked = false
        binding7.checkBox3.text = "invisible"

        binding7.checkBox3.setOnClickListener {
            //암호를 보여줄것
            if(binding7.checkBox3.isChecked == true){
                binding7.editTextTextPassword.inputType = InputType.TYPE_CLASS_TEXT
                binding7.checkBox3.text = "visible"
            }else{
                //암호를 보여주지 말것
                binding7.editTextTextPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding7.checkBox3.text = "invisible"

            }
        }



//        binding6.tvLongClick.setOnClickListener {
//            Toast.makeText(applicationContext,binding6.edtPassword.text.toString(),Toast.LENGTH_SHORT).show()
//        }

        binding6.tvLongClick.setOnLongClickListener {

            binding6.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            Toast.makeText(applicationContext, binding6.edtPassword.text.toString(), Toast.LENGTH_SHORT).show()

            return@setOnLongClickListener (true)
        }
        binding6.tvLongClick.setOnClickListener {
            binding6.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

//        binding3.btn10.setOnClickListener {
//            if(flag==true){
//                binding3.btn10.visibility = View.VISIBLE
//                binding3.btn17.visibility = View.VISIBLE
//                flag = false
//            }else{
//                binding3.btn11.visibility = View.INVISIBLE
//                binding3.btn17.visibility = View.GONE
//                flag = true
//            }
//        }
//
//
    }
}
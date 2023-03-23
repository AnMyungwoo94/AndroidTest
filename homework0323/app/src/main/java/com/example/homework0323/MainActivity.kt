package com.example.homework0323

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.homework0323.databinding.ActivityMainBinding
import com.example.homework0323.databinding.RegisterLayoutBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCourtomDialog.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val userBinding: RegisterLayoutBinding
        val dialogBuilder = AlertDialog.Builder(this)
        var userDialog: AlertDialog

        //사용자화면 인플렉션
        userBinding = RegisterLayoutBinding.inflate(layoutInflater)
        //사용자 다이얼로그 제목, 뷰설정 보이기
        dialogBuilder.setTitle("(주)미래아이티캠퍼스")
        dialogBuilder.setIcon(R.drawable.baseline_edit_note_24)
        dialogBuilder.setView(userBinding.root)
        //dialogBuilder.create() dialogBuilder정보를 dismiss()새로 추가해서 userdialog 넘겨줌.
        userDialog = dialogBuilder.create()
        userDialog.show()
        //이벤트처리하기
        userBinding.btnCancel.setOnClickListener {
            Toast.makeText(applicationContext,"취소되었습니다.", Toast.LENGTH_SHORT).show()
            userDialog.dismiss()
        }

        userBinding.btnregister.setOnClickListener {
            Toast.makeText(applicationContext,"신청되었습니다.", Toast.LENGTH_SHORT).show()
            binding.tvMessage.setText(" 회원가입을 축하드립니다 ^_^ \n\n             < 가입정보 출력 >   \n 1.이름 : ${userBinding.edtName.text.toString()} \n 2.나이 : ${userBinding.edtAge.text.toString()}\n 3.성별 : ${userBinding.edtGender.text.toString()} \n" +
                    " 4.주소 : ${userBinding.edtAddress.text.toString()} \n 5.연락처 : ${userBinding.edtPhonemember.text.toString()}")
            userDialog.dismiss()
        }

    }
}
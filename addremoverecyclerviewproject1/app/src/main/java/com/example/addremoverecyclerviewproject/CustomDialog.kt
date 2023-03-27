package com.example.addremoverecyclerviewproject

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.WindowManager
import com.example.addremoverecyclerviewproject.databinding.ActivityMainBinding
import com.example.addremoverecyclerviewproject.databinding.DialodCustomBinding

class CustomDialog(val context: Context, val mainBinding: ActivityMainBinding) {
    val dialog = Dialog(context)
    var count = 0

    fun showDialog() {
        val binding = DialodCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnSave.setOnClickListener {
            count++
            val tvName = binding.edtName.text.toString()
            val tvAge = binding.edtAge.text.toString()
            val tvEmail = binding.edtEmail.text.toString()
            var dataVO: DataVO? = null

            if (count % 2 == 0) {
                dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.ironman)
            } else {
                dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.wonderwoman)
            }
            (context as MainActivity).refreshRecyclerView(dataVO)
            dialog.dismiss()
        }
    }
}
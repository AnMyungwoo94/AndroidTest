package com.example.myapplication

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMain3Binding
import com.example.myapplication.databinding.RegisterLayoutBinding
import com.example.myapplication.databinding.ToastLayoutBinding

class MainActivity3 : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener(this)
        binding.btnDate.setOnClickListener(this)
        binding.btnDate1.setOnClickListener(this)
        binding.btnDialog.setOnClickListener(this)
        binding.btnItemDialog.setOnClickListener(this)
        binding.btnItemDialog2.setOnClickListener(this)
        binding.btnSingleItemDialog.setOnClickListener(this)
        binding.btnCourtomDialog.setOnClickListener(this)
        binding.btnFineLocate.setOnClickListener(this)
        binding.btnRington.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDate -> {
                DatePickerDialog(this, this, 2023, 3 - 1, 23).show()
            }
            R.id.btnDate1 -> {
                TimePickerDialog(this, this, 13, 45, true).show()
            }
            R.id.btnDialog -> {

                val dialog = AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMessage("알림창 정보를 보여드립니다.")

                    setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Toast.makeText(this@MainActivity3, "ok클릭하셨어요", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })
                    setNegativeButton("No", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Toast.makeText(this@MainActivity3, "no클릭하셨어요", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })
                    show()
                }
            }
            R.id.btnItemDialog -> {
                val eventHandler = object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(
                            this@MainActivity3, "${
                                if (which == -1) {
                                    "ok"
                                } else {
                                    "no"
                                }
                            }클릭하셨어요", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                val dialog = AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setItems(items, object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            binding.btnItemDialog.text = items[which]
                        }
                    })
                    setNegativeButton("no", eventHandler)
                    show()
                }
            }
            R.id.btnItemDialog2 -> {
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                val dialog = AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMultiChoiceItems(items, booleanArrayOf(true, false, false, false), object : DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                           if(isChecked == true){
                               binding.btnItemDialog2.text = items[which]
                           }
                        }
                    })
                    setPositiveButton("Yes", object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Toast.makeText(applicationContext, "선택했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    })
                    setNegativeButton("Cancel",null)
                    show()
                }
            }
            R.id.btnSingleItemDialog -> {
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                val dialog = AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setSingleChoiceItems(items, 1, object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                           binding.btnSingleItemDialog.text = items[which]
                        }
                    })
                    setNegativeButton("close",null)
                    setCancelable(false)
                    show()
                }.setCanceledOnTouchOutside(true)
            }
            R.id.btnCourtomDialog -> {
                val userBinding: RegisterLayoutBinding
                val dialogBuilder = AlertDialog.Builder(this)
                var userDialog: AlertDialog

                //사용자화면 인플렉션
                userBinding = RegisterLayoutBinding.inflate(layoutInflater)
                //사용자 다이얼로그 제목, 뷰설정 보이기
                dialogBuilder.setTitle("사용자 이름 입력하기 창")
                dialogBuilder.setIcon(R.drawable.computer_24)
                dialogBuilder.setView(userBinding.root)
                //dialogBuilder.create() dialogBuilder정보를 dismiss()새로 추가해서 userdialog 넘겨줌.
                userDialog = dialogBuilder.create()
                userDialog.show()
                //이벤트처리하기
                userBinding.btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"취소되었습니다",Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
                userBinding.btnregister.setOnClickListener {
                    binding.tvMessage.text = userBinding.edtName.text.toString()
                    userDialog.dismiss()
                }
            }
            R.id.btnFineLocate -> {
               val state  = ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_FINE_LOCATION")
               if(state == PackageManager.PERMISSION_GRANTED){
                   binding.tvMessage.text = "위치추적 권한허용"
               }else{
                   binding.tvMessage.text = "위치추적 권한불허"
               }
            }
            R.id.btnRington-> {
                //unifrom Resource Identifier, 리소스를 구분하는 식별자.
                // 안드로이드에서 uri역할은 리소스(외부앱, 이미지, 텍스트 등)에 접근할 수 있는 식별자역할
                val notificationUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rington = RingtoneManager.getRingtone(applicationContext,notificationUri)
                rington.play()
            }
        }
    }
    //콜백함수
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(applicationContext, "${year} ${month + 1} ${dayOfMonth}", Toast.LENGTH_SHORT)
            .show()
    }
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(applicationContext, "${hourOfDay}시 ${minute}분", Toast.LENGTH_SHORT).show()
    }
}

//     override fun onClick(v: View?) {
//    when (v?.id) {
//        R.id.btnDate -> {
//            DatePickerDialog(this,
//                {
//                        view: DatePicker?,
//                        year: Int,
//                        month: Int,
//                        dayOfMonth: Int
//                    ->
//                    Toast.makeText(
//                        applicationContext,
//                        "${year} ${month + 1} ${dayOfMonth}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }, 2023, 3 - 1, 23
//            ).show()
//        }
//    }
//}


//               DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
//                   override fun onDateSet(
//                       view: DatePicker?,
//                       year: Int,
//                       month: Int,
//                       dayOfMonth: Int
//                   ) {
//                      Toast.makeText(applicationContext,"${year} ${month+1} ${dayOfMonth}",Toast.LENGTH_SHORT).show()
//                   }
//               }, 2023, 3-1, 23).show()
//            }


//            R.id.btnToast -> {
//                val toast = Toast.makeText(applicationContext, "토스트메시지", Toast.LENGTH_SHORT)
//                toast.duration = Toast.LENGTH_LONG
//                toast.setGravity(Gravity.TOP, 0, 0)
//
//                //var toastLayout = LayoutInflater.from(applicationContext).inflate(R.layout.toast_layout, null)
//                //toast.view = toastLayout.rootView
//
//                var toastLayoutBinding : ToastLayoutBinding
//                toastLayoutBinding = ToastLayoutBinding.inflate(layoutInflater)
//                toast.view = toastLayoutBinding.root
//                toast.show()
//
////                toast.setText("정신일도 하사불성")
////                toast.addCallback(object : Toast.Callback() {
////                    override fun onToastShown() {
////                        super.onToastShown()
////                        binding.btnToast.text = "토스트 보이기"
////                    }
////                    override fun onToastHidden() {
////                        super.onToastHidden()
////                        binding.btnToast.text = "토스트 감추기"
////                    }
////                })





package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import com.example.myapplication.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding : ActivityMain4Binding
    lateinit var manager : NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNotificate.setOnClickListener {
            //notificationManger 객체참조변수 1
            //notificationCompat.Builder 객체참조변수 1
            manager =  getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            //channel 객체참조변수를 만든다. (API26 버전이상부터 채널을 만들어줘야한다.) 2
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                //26버전 이상이 채널객체참조변수 3
                val channelID: String = "anw-channel"
                val channelName = "My AMW Channel"
                val channel = NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH)

                //채널에 대한 정보를 등록한다.
                channel.description = "My AMW Channel Description"
                channel.setShowBadge(true)

                //알림음 오디오 설정
                val notificationUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributesBuilder = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
                channel.setSound(notificationUri, audioAttributesBuilder)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100,200,100,200)

                //채널을 등록 notificationManger 4
                manager.createNotificationChannel(channel)

                //채널아이디를 이용해서 빌더생성 5
                builder = NotificationCompat.Builder(this, channelID)
            }else{
                //채널아이디를 이용하지않고 빌더생성 5
                builder = NotificationCompat.Builder(this)
            }

            //6. builder 알림창이 어떤방법으로 구현할지 보여주는것
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("My first Notification")
            builder.setContentText("my first Notificantion cantent")
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.view2))

            //7. 알림이 발생후 터치시 내가 지정한 액티비티로 화면 전환하는 pendingIntent 기능부여하기
            //7. 알림이 발생후 터시치 내가 Broadcast화면으로 정보를 알려준다.
//            val intent = Intent(this, Detailactivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_IMMUTABLE)
//            builder.setContentIntent(pendingIntent)

/*            //8. 알람에 액션등록하기
            val actionIntent = Intent(this, OneReceiver::class.java)
            val actionPendingIntent =  PendingIntent.getBroadcast(this,20,actionIntent, PendingIntent.FLAG_IMMUTABLE)
            builder.addAction(NotificationCompat.Action.Builder(
                android.R.drawable.stat_notify_more,
                "Action",
                actionPendingIntent
            ).build())*/

            //9. 알림창에서 데이터를 입력하면 해당되는 데이터를 브로드캐스트로 받아옴.
            //9-1. 알림창에서 입력할 수 있는 기능부여
            val remoteinput = RemoteInput.Builder("kdj_noti_reply").run {
                setLabel("답장글 써주세요")
                build()
            }
            val actionIntent = Intent(this, OneReceiver::class.java)
            val actionPendingIntent =  PendingIntent.getBroadcast(this,30,actionIntent, PendingIntent.FLAG_MUTABLE)
            builder.addAction(NotificationCompat.Action.Builder(
                R.drawable.send_24,
                "답장",
                actionPendingIntent
            ).addRemoteInput(remoteinput).build())

//            builder.setAutoCancel(false)
//            builder.setOngoing(true)

            //10. manager 알림발생
            manager.notify(11, builder.build())
        }
        binding.btnNotificateCanncel.setOnClickListener {
            manager.cancel(11)
        }
    }
}
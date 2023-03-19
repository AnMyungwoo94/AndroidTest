package com.example.homework03166

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.homework03166.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled = true //자바 스크립트 허용
        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()

        // 링크주소를 로드함
        binding.webView.loadUrl("http://www.naver.com")


    }

    override fun onBackPressed() { //백버튼 누를 시 수행할 로직구현
        if( binding.webView.canGoBack()){
            //웹사이트에서 뒤로 갈 페이지가 존재 한다면
            binding.webView.goBack() //웹사이트 뒤로가기
        }else{
            super.onBackPressed() //본래의 백버튼 기능 수행 (안드로이드)
        }
    }
}
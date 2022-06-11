package com.neppplus.librarypractice_20220611

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        imgProfile.setOnClickListener {

//            이미지뷰, 텍스트뷰, LinearLayout 등도 단순 클릭 이벤트 지원.

//            별도의 사진을 크게 보는 액티비티로 이동.

            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)


        }


        btnCall.setOnClickListener {

//            CALL_PHONE 권한 확인 => 승인 되었을때만 CALL 액션 수행.
//            승인이 안되었다면, 토스트로 "권한 문제로 전화 연결 불가" 라고 띄워주자.


            val myUri = Uri.parse("tel:01055556666")

            val myIntent = Intent( Intent.ACTION_CALL, myUri )

            startActivity(myIntent)

        }


    }

    fun setValues() {

    }

}
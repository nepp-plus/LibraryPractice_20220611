package com.neppplus.librarypractice_20220611

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




        }

    }

    fun setValues() {

    }

}
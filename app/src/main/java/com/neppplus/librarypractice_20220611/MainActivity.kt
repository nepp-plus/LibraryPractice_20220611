package com.neppplus.librarypractice_20220611

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

//            권한 승인 여부에 따른, 상황 대처 계획서(~~Listener)를 먼저 만들고 변수에 담아두자.

            val pl = object : PermissionListener {
                
                
                override fun onPermissionGranted() {
//                    권한이 승인됐을때 할 일 => 실제 전화 걸기

                    val myUri = Uri.parse("tel:01055556666")

                    val myIntent = Intent( Intent.ACTION_CALL, myUri )

                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    거부 되었을때 해줄 일 => 토스트로 안내 문구

                    Toast.makeText(this@MainActivity, "권한 문제로 전화 연결이 불가능 합니다.", Toast.LENGTH_SHORT)
                        .show()
                    
                }

            }


//            계획서를 들고, 실제로 권한 확인

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions( Manifest.permission.CALL_PHONE )
                .check()


        }


    }

    fun setValues() {

//        인터넷에 있는 이미지를 그대로 이미지뷰에 표시.
//        https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202110/04/b9651a63-1ba7-4ee3-bbe8-3c83fbc1f71f.jpg
//        위 주소의 이미지를 imgWeb에서 표시. (drawable 사용 X)

        Glide.with(this).load("https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202110/04/b9651a63-1ba7-4ee3-bbe8-3c83fbc1f71f.jpg").into(imgWeb)

    }

}
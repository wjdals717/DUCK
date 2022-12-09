package com.example.nogoduck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class First_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_first_screen)
        //setContentView(R.layout.activity_first_screen)

        // 센서 데이터 확인 버튼 클릭시 Data_Check로 이동
        val intent = Intent(this, Data_Check::class.java)

        // 회원 정보 확인 버튼 지정
        val buttonView = findViewById<Button>(R.id.bt_data)
        // 클릭 리스너
        buttonView.setOnClickListener{
            startActivity(intent)
        }

        // 회원 등록 및 확인 클릭시 로 이동
        val intent1 = Intent(this, New_Reg::class.java)

        // 신규 등록 버튼 지정
        val buttonView1 = findViewById<Button>(R.id.bt_new)
        // 클릭 리스너
        buttonView1.setOnClickListener{
            startActivity(intent1)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

}
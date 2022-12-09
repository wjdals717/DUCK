package com.example.nogoduck

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.Array.getBoolean

class New_Reg : AppCompatActivity() {

    val TAG: String = "Register"
    var isExistBlank = false

    override fun onCreate(savedInstanceState: Bundle?) {  //앱이 처음 실행될 때 한번 수행하는 곳(초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_reg)

        loadData()  //저장되어있던 값을 SETTEXT

        title = "NOGODUCK"

        //버튼 클릭시 이벤트
//        var btn = resources.getBoolean(R.id.btn1)
        val btn = findViewById<Button>(R.id.btn1)


        btn.setOnClickListener {
            Log.d(TAG, "등록 완료")

            val name11 = findViewById<EditText>(R.id.name1).toString()
            val birth11 = findViewById<EditText>(R.id.birth).toString()
            val address11 = findViewById<EditText>(R.id.address).toString()
            val phone11 = findViewById<EditText>(R.id.phone).toString()
            val name211 = findViewById<EditText>(R.id.p_name).toString()
            val phone211 = findViewById<EditText>(R.id.p_phone).toString()

            isExistBlank = (TextUtils.isEmpty(name11) && TextUtils.isEmpty(birth11) && TextUtils.isEmpty(address11)
                    && TextUtils.isEmpty(phone11) && TextUtils.isEmpty(name211) && TextUtils.isEmpty(phone211))
            if(!isExistBlank)
                Toast.makeText(this, "등록 완료", Toast.LENGTH_SHORT).show()

        }
    }


    fun saveData() {
        val name = findViewById<EditText>(R.id.name1)
        val birth = findViewById<EditText>(R.id.birth)
        val address = findViewById<EditText>(R.id.address)
        val phone = findViewById<EditText>(R.id.phone)
        val name2 = findViewById<EditText>(R.id.p_name)
        val cb1 = findViewById<CheckBox>(R.id.cb1)
        val cb2 = findViewById<CheckBox>(R.id.cb2)
        val cb3 = findViewById<CheckBox>(R.id.cb3)
        val cb4 = findViewById<CheckBox>(R.id.cb4)
        val cb5 = findViewById<CheckBox>(R.id.cb5)
        val cb6 = findViewById<CheckBox>(R.id.cb6)
        val cb7 = findViewById<CheckBox>(R.id.cb7)
        val cb8 = findViewById<CheckBox>(R.id.cb8)
        val cb9 = findViewById<CheckBox>(R.id.cb9)
        val phone2 = findViewById<EditText>(R.id.p_phone)

        val pref = getSharedPreferences("pref", 0) //0: 저장 옵션
        val edit = pref.edit() //수정모드
        edit.putString("name", name.text.toString()) //1번째 인자에는 키 값을, 2번째
        edit.putString("birth", birth.text.toString()) //1번째 인자에는 키 값을, 2번째
        edit.putString("address", address.text.toString()) //1번째 인자에는 키 값을, 2번째
        edit.putString("phone", phone.text.toString()) //1번째 인자에는 키 값을, 2번째
        edit.putString("name2", name2.text.toString()) //1번째 인자에는 키 값을, 2번째
        edit.putString("phone2", phone2.text.toString()) //1번째 인자에는 키 값을, 2번째
        /*val isChecked = getBoolean("save", 0) // key와 value형태로 저장
        saveCheckBox.setChecked(isChecked)
        if (isChecked) { // 체크된 상태라면 "email"키에 ""값 저장
            val email: String = getString("email", "")
            emailEditText.setText(email)
        }*/
        edit.apply() //값을 저장 완료
    }

    fun loadData() {
        val name = findViewById<EditText>(R.id.name1)
        val birth = findViewById<EditText>(R.id.birth)
        val address = findViewById<EditText>(R.id.address)
        val phone = findViewById<EditText>(R.id.phone)
        val name2 = findViewById<EditText>(R.id.p_name)
        val cb1 = findViewById<CheckBox>(R.id.cb1)
        val cb2 = findViewById<CheckBox>(R.id.cb2)
        val cb3 = findViewById<CheckBox>(R.id.cb3)
        val cb4 = findViewById<CheckBox>(R.id.cb4)
        val cb5 = findViewById<CheckBox>(R.id.cb5)
        val cb6 = findViewById<CheckBox>(R.id.cb6)
        val cb7 = findViewById<CheckBox>(R.id.cb7)
        val cb8 = findViewById<CheckBox>(R.id.cb8)
        val cb9 = findViewById<CheckBox>(R.id.cb9)
        val phone2 = findViewById<EditText>(R.id.p_phone)

        val pref = getSharedPreferences("pref",0)
        name.setText(pref.getString("name","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값
        birth.setText(pref.getString("birth","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값
        address.setText(pref.getString("address","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값
        phone.setText(pref.getString("phone","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값
        name2.setText(pref.getString("name2","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값
        //cb1.setText(pref.getString("cb1",""))
        phone2.setText(pref.getString("phone2","")) //1번째 인자에서는 저장할 당시의 키 값, 2번째 인자는 키 값의 데이터가 존재하지 않을 경우 대체 값



    }

    override fun onDestroy() { //해당 액티비티가 종료되는 시점이 다가올 때 호출
        super.onDestroy()

        saveData() //EDIT TEXT 값을 저장
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}
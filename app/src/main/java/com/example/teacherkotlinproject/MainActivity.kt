package com.example.teacherkotlinproject

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences

    //LoginActivity -
    //PasswordActivity

    //Переименовать MainActivity в LoginActivity, добавить Button логин и editText - логин
    //Сделать сохранение Логина в SharedPreferences
    //Добавить PasswordActivity и TextView, а в TextView отображать данные из SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = SharedPreferences(this)
        setSharedDataAction()
        getSharedDataAction()
    }

    private fun setSharedDataAction() {
        set_shared_btn.setOnClickListener {
            val value = input_edit_text.text.toString()
            if (!value.isNullOrEmpty()) {
                shared.myPersonalData = "${shared.myPersonalData} $value \n"
                shared.isHasPersonalData = true
            }
            input_edit_text.setText("")
        }
    }

    private fun getSharedDataAction() {
        get_shared_btn.setOnClickListener {
            from_shared_text_view.text = "${shared.myPersonalData} \n isHasData = ${shared.isHasPersonalData} "
        }
    }
}
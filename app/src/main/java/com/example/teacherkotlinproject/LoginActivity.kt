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

class LoginActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    //LoginActivity -
    //PasswordActivity

    //+ 1. Переименовать MainActivity в LoginActivity, добавить Button логин и editText - логин
    /*2. При нажатии на кнопку Login - Сделать проверку если логин не пустой -> сохранение значения Логина в SharedPreferences
    и переходите в PasswordActivity и закрываете LoginActivity
    иначе вывести TOAST с ошибкой*/
    //3. Добавить PasswordActivity и TextView, а в TextView отображать данные из SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = SharedPreferences(this)

        loginAction()
    }

    private fun loginAction() {
        login_btn.setOnClickListener {
            val login = input_login.text.toString()
            if (login.isNotEmpty()) {
                shared.login = login
                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showToast("Поле не должно быть пустым!")
            }
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
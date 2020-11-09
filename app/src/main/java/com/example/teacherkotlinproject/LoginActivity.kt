package com.example.teacherkotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

//0. Подготовиться к тесту.
//1. Сделать проверку на авторизацию, если вы перешли на экран Main активити, то нужно сохранить это состояние
// при следующем запуске запускать MainActivity, а не LoginActivity
//2. Добавить кнопку logout в майн активити, при нажатии и нужно очищать данные из sharedPreferences и переходить в логин Активити

class LoginActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        shared = SharedPreferences(this)

        registrationAction()
        loginAction()
    }

    private fun registrationAction() {
        registration_button.setOnClickListener {
            intentToNext(this, RegistrationActivity::class.java)
        }
    }

    private fun loginAction() {
        login_btn.setOnClickListener click@ {
            val login = input_login.text.toString()
            if (checkFieldIsEmpty(login, this, "Введите логин")) return@click
            if (checkFieldIsSame(login, shared.login, this, "Логин не найден")) return@click

            intentToNext(this, PasswordActivity::class.java)
            finish()
        }
    }
}
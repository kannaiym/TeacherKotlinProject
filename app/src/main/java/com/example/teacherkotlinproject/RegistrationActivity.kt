package com.example.teacherkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        shared = SharedPreferences(this)
        registrationAction()
    }

    private fun registrationAction() {
        registration_button.setOnClickListener click@ {
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confirm_password_edit_text.text.toString()

            if (checkFieldIsEmpty(login, this, "Введите логин")) return@click
            if (checkFieldIsEmpty(password, this, "Введите пароль")) return@click
            if (checkFieldIsEmpty(confirmPassword, this, "Введите повторный пароль")) return@click
            if (checkFieldIsSame(password, confirmPassword, this, "Пароль должен совпадать в двух полях.")) return@click

            successRegistered(login, confirmPassword)
        }
    }

    private fun successRegistered(login: String, confirmPassword: String) {
        shared.login = login
        shared.password = confirmPassword
        showToast(this, "Вы успешно зарегистрировались!")
        finish()
    }

}
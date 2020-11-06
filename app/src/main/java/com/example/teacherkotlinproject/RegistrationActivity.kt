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
        registration_button.setOnClickListener {
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confirm_password_edit_text.text.toString()

            if (login.isEmpty()) {
                showToast(this, "Введите логин")
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                showToast(this, "Введите пароль")
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                showToast(this, "Введите повторный пароль")
                return@setOnClickListener
            }

            shared.login = login
            shared.password = confirmPassword
            showToast(this, "Вы успешно зарегистрировались!")
            finish()
        }
    }

}
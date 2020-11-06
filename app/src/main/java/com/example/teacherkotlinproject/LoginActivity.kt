package com.example.teacherkotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

//0. !!!ПОДГОТОВИТЬ ВОПРОСЫ ПО ТЕМАМ, КОТОРЫЕ НЕ ПОНЯТНЫ!!!
//1. (RegistrationActivity) Сделать проверку на схожесть паролей, если они разные вывести ошибку
//2. (RegistrationActivity) Вынести проверку значений в EditText в отдельный метод
//3. (RegistrationActivity) Сделать проверку на количество символов в логин и пароль (>= 6)
/*4. (RegistrationActivity,
      LoginActivity,
      PasswordActivity) Вынести их проверки полей в отдельный файл */
//5.  Вынести переход на новую актвити в отдельный файл
//6. (ДОПОЛНИТЕЛЬНО) Вынести все размеры dp, sp в файл dimens
//7. (ДОПОЛНИТЕЛЬНО) Вынести все строки в ресурсы

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
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginAction() {
        login_btn.setOnClickListener {
            val login = input_login.text.toString()
            if (login.isNotEmpty()) {
                checkLoginField(login)
                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showToast(this, resources.getString(R.string.field_cannot_be_empty))
            }
        }
    }

    private fun checkLoginField(login: String) {
        if (login != shared.login) {
            showToast(this, resources.getString(R.string.login_is_not_find))
            input_login.setText("")
            return
        }
    }
}
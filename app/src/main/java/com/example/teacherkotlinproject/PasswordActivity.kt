package com.example.teacherkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        shared = SharedPreferences(this)
        confirmAction()
    }

    private fun confirmAction() {
        check_password_button.setOnClickListener click@ {
            val password = password_edit_text.text.toString()
            if (checkFieldIsEmpty(password, this, resources.getString(R.string.enter_password_field))) return@click
            if (checkFieldIsSame(password, shared.password, this, resources.getString(R.string.password_not_same))) return@click

            intentToNext(this, MainActivity::class.java)
            finish()
        }
    }

}
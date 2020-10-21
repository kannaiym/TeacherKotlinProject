package com.example.teacherkotlinproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constrate_layout.*

class MainActivity : AppCompatActivity() {

    var name = "Sergey"
    var lastname = "Karukes"
    var age = "21"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constrate_layout)
        setViews()
        saveAction()
        //MainActivity - camelCase - это для классов
        //sizeOfShoes - camelCase - методов и переменных kotlin & java
        //size_of_shoes - snake_case - ресурсов
    }

    private fun setViews() {
        username_value_text_view.text = name
        lastname_value_text_view.text = lastname
        age_value_text_view.text = age
    }

    private fun saveAction() {
        save_button.setOnClickListener {
            val phone = phone_edit_text.text.toString()
            val city = city_edit_text.text.toString()
            val region = region_edit_text.text.toString()

            checkFields(phone, "Поле номер телефона не может быть пустым")
            checkFields(city, "Поле города не может быть пустым")
            checkFields(region, "Поле область не может быть пустым")

            Log.v("SAVE_LOG", "$name, $lastname, $age, $phone, $city, $region")
        }
    }

    private fun checkFields(value: String, message: String) {
        if (value.isEmpty()) {
            showToast(message)
            return
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
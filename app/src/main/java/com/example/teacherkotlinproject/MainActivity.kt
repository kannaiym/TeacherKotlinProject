package com.example.teacherkotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //HW 006
    //При нажатии на кнопку передавать значение из EditText во 2-й активити и выводить Toast
    //Каждый раз когда вы нажимаете на кнопку перейти на 2-й активити, то добавлять ваше значение в Array
    //Добавить вторую кнопку в mainActivity, при нажатии на которую вы будете выводить все значения в Toast
    private val array = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivityAction()
        displayArrayValuesAction()
    }

    private fun nextActivityAction() {
        go_to_next.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val valueFromEditText = input.text.toString()
            intent.putExtra("value", valueFromEditText)
            array.add(valueFromEditText)
            startActivity(intent)
        }
    }

    private fun displayArrayValuesAction() {
        display_all_values.setOnClickListener {
            var message = ""
            array.forEach {
                message = "$message $it \n"
            }
            showToast(message)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
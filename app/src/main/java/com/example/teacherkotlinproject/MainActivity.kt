package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Сделать обработку всех кнопок чтобы от 0 до 9 можно было добавлять в EditText
    //Сделать добавление символов / * + -
    //Сделать очистку TextView на кнопку AC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1()
        btn2()
        btn3()
    }

    //здесь добавить 0

    private fun btn1() {
        btn_1.setOnClickListener {
            var default = result.text.toString()
            default += "1"
            result.text = default
        }
    }

    private fun btn2() {
        btn_2.setOnClickListener {
            var default = result.text.toString()
            default += "2"
            result.text = default
        }
    }

    private fun btn3() {
        btn_3.setOnClickListener {
            var default = result.text.toString()
            default += "3"
            result.text = default
        }
    }

    //продолжите добавлять с 4

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
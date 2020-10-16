package com.example.teacherkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isMinus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResult()
        setPlusOperator()
        setMinusOperator()
    }

    private fun getResult() {
        count_button.setOnClickListener {
            val first = first_edit_text.text.toString().toInt()
            val second = second_edit_text.text.toString().toInt()
            var result = first + second

            if (isMinus) result = first - second
            else result = first + second

            first_edit_text.text.clear()
            second_edit_text.text.clear()
            result_text_view.text = result.toString()
        }
    }

    private fun setPlusOperator() {
        minus_button.setOnClickListener {
            isMinus = false
        }
    }

    private fun setMinusOperator() {
        minus_button.setOnClickListener {
            isMinus = true
        }
    }

}
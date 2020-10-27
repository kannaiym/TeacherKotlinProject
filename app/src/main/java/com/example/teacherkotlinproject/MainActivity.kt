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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nextActivityAction()
    }

    private fun nextActivityAction() {
        go_to_next.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val valueFromEditText = input.text.toString()
            intent.putExtra("value", valueFromEditText)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        val modifyData = data.getStringExtra("modify_value")
        input.setText(modifyData)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
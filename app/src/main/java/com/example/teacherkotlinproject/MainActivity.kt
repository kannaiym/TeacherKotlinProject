package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constrate_layout.*

class MainActivity : AppCompatActivity() {

    //векторные картинки - svg, png
    //растровые картинки - jpeg, jpg, gif, png

    //Добавить ещё 3-4 картинки городов
    //при нажатии на кнопку выбрать любую картинку из массива посредством класса Random

    val imageArray = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constrate_layout)
        changeIconAction()
    }

    private fun changeIconAction() {
        change_image.setOnClickListener {
            image.setImageResource(R.mipmap.paris)
            val number = (0..1000).random()
            showToast("Радомное число равно = $number")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
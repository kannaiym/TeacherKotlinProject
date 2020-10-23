package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.constrate_layout.*

class MainActivity : AppCompatActivity() {

    //val - константа, переменная, у которой нельзя поменять значение
    //var - переменная, у которой можно поменять значение
    val imageArray = mutableListOf<Int>().apply {
        add(R.mipmap.paris)
        add(R.mipmap.london)
        add(R.mipmap.madrid)
    }

    val imageDescription = mutableListOf<String>().apply {
        add("это paris")
        add("это london")
        add("это madrid")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constrate_layout)
        changeIconAction()
    }

    private fun changeIconAction() {
        change_image.setOnClickListener {
            val random = imageArray.random()
            image.setImageResource(random)
            showToast(getIndexFromElement(random))
        }
    }

    private fun getIndexFromElement(element: Int): String {
        var index: Int? = null
        for ((i, item) in imageArray.withIndex()) {
            if (item == element) index = i
        }
        return imageDescription[index!!]
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
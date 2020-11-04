package com.example.teacherkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class ListOfEqualsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getListOfEquals()
    }

    private fun getListOfEquals() {
        val value = intent.getStringArrayListExtra("list")
        var result: String = ""
        if (value != null)
        for (i in value) {
            result += "$i \n"
        }
        list_txt.text = result
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
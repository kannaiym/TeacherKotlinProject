package com.example.teacherkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getIntentFromPreviousActivity()
        goToNextAction()
    }

    private fun getIntentFromPreviousActivity() {
        val valueFromFirstActivity = intent.getStringExtra("value")
        showToast(valueFromFirstActivity)
    }

    // go_to_next
    private fun goToNextAction() {
        go_to_next.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
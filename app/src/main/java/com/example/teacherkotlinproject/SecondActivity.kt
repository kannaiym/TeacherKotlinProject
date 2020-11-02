package com.example.teacherkotlinproject

import android.app.Activity
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
        goToMainAction()
    }

    private fun getIntentFromPreviousActivity() {
        val valueFromFirstActivity = intent.getStringExtra("value")
        output.setText(valueFromFirstActivity)
    }

    private fun goToMainAction() {
        go_to_main.setOnClickListener {
            val intent = Intent()
            val output = output.text.toString()
            intent.putExtra("modify_value", output)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
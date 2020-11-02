package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var enteredNumber = 0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn0()
        btn1()
        btn2()
        btn3()
        btn4()
        btn5()
        btn6()
        btn7()
        btn8()
        btn9()

        btnSplit()
        btnPow()
        btnPlus()
        btnMinus()

        btnAC()
        btnEquals()
    }

    private fun btn0() {
        btn_0.setOnClickListener {
            default = result.text.toString()
            default += "0"
            lastNumber += "0"
            result.text = default
        }
    }

    private fun btn1() {
        btn_1.setOnClickListener {
            default = result.text.toString()
            default += "1"
            lastNumber += "1"
            result.text = default
        }
    }

    private fun btn2() {
        btn_2.setOnClickListener {
            default = result.text.toString()
            default += "2"
            lastNumber += "2"
            result.text = default
        }
    }

    private fun btn3() {
        btn_3.setOnClickListener {
            default = result.text.toString()
            default += "3"
            lastNumber += "3"
            result.text = default
        }
    }

    private fun btn4() {
        btn_4.setOnClickListener {
            default = result.text.toString()
            default += "4"
            lastNumber += "4"
            result.text = default
        }
    }

    private fun btn5() {
        btn_5.setOnClickListener {
            default = result.text.toString()
            default += "5"
            lastNumber += "5"
            result.text = default
        }
    }

    private fun btn6() {
        btn_6.setOnClickListener {
            default = result.text.toString()
            default += "6"
            lastNumber += "6"
            result.text = default
        }
    }

    private fun btn7() {
        btn_7.setOnClickListener {
            default = result.text.toString()
            default += "7"
            lastNumber += "7"
            result.text = default
        }
    }

    private fun btn8() {
        btn_8.setOnClickListener {
            default = result.text.toString()
            default += "8"
            lastNumber += "8"
            result.text = default
        }
    }

    private fun btn9() {
        btn_9.setOnClickListener {
            default = result.text.toString()
            default += "9"
            lastNumber += "9"
            result.text = default
        }
    }

    private fun btnEquals() {
        btn_equals.setOnClickListener {
            if (operand == "*") {
                val sum = enteredNumber * lastNumber.toInt()
                result.text = sum.toString()
            } else if (operand == "/") {
                val sum = enteredNumber / lastNumber.toInt()
                result.text = sum.toString()
            } else if (operand == "+") {
                val sum = enteredNumber + lastNumber.toInt()
                result.text = sum.toString()
            } else if (operand == "-") {
                val sum = enteredNumber - lastNumber.toInt()
                result.text = sum.toString()
            }
        }
    }

    private fun btnSplit() {
        btn_split.setOnClickListener {
            default = result.text.toString()
            default += "/"
            result.text = default
        }
    }



    private fun btnPow() {
        btn_pow.setOnClickListener {
            default = result.text.toString()
            if (isDecimal(default.last())) {

                if (enteredNumber == 0) enteredNumber += lastNumber.toInt()
                else enteredNumber *= lastNumber.toInt()
                lastNumber = ""
                default += "*"
                result.text = default
            } else {
                default = default.dropLast(1)
                default += "*"
                result.text = default
            }
            operand = "*"
        }
    }

    private fun btnPlus() {
        btn_plus.setOnClickListener {
            default = result.text.toString()
            default += "+"
            result.text = default
        }
    }

    private fun btnMinus() {
        btn_minus.setOnClickListener {
            default = result.text.toString()
            default += "-"
            result.text = default
        }
    }

    private fun btnAC() {
        btn_clear.setOnClickListener {
            enteredNumber = 0
            lastNumber = ""
            result.text = ""
        }
    }

    private fun isDecimal(last: Char): Boolean {
        val charArray = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (char in charArray) {
            if (last == char) return true
        }
        return false
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
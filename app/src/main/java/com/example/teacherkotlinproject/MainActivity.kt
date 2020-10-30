package com.example.teacherkotlinproject

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var enteredNumber: Double = 0.0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""
    private val decimalArrayButtons = mutableListOf<Button>()

    //Создать новый массив для кнопок операндов.
    //В целых числах убрать дробное значение. (90 + 90 = 180)
    //Сократить длину результата при вычитании дробных чисел (4.529999999999999 -> 4.52) - ДОПОЛНИТЕЛЬНОЕ ЗАДАНИЕ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDecimalButtonsToArray()
        setAllButton()

        btnSplit()
        btnPow()
        btnPlus()
        btnMinus()

        btnAC()
        btnEquals()
        btnRemoveLast()
    }

    private fun setDecimalButtonsToArray() {
        decimalArrayButtons.apply {
            add(btn_0)
            add(btn_1)
            add(btn_2)
            add(btn_3)
            add(btn_4)
            add(btn_5)
            add(btn_6)
            add(btn_7)
            add(btn_8)
            add(btn_9)
            add(btn_dot)
        }
    }

    private fun setAllButton() {
        for (btn in decimalArrayButtons) {
            btn.setOnClickListener {
                default = result.text.toString()
                default += btn.text
                lastNumber += btn.text
                result.text = default
            }
        }
    }

    private fun btnRemoveLast() {
        btn_remove.setOnClickListener {
        if (default.isNotEmpty()) {
                default = default.dropLast(1)
                result.text = default
            }
        }
    }

//    val f: Double = 0.0 ~ 4 m
//    val d: Float = 0.0F ~ 1.8 billion

    private fun btnEquals() {
        if (lastNumber.isNotEmpty())
        btn_equals.setOnClickListener {
            if (operand == "*") enteredNumber *= lastNumber.toDouble()
            else if (operand == "/") enteredNumber /= lastNumber.toDouble()
            else if (operand == "+") enteredNumber += lastNumber.toDouble()
            else if (operand == "-") enteredNumber -= lastNumber.toDouble()
            result.text = enteredNumber.toString()
            lastNumber = ""
        }
    }

    private fun btnSplit() {
        btn_split.setOnClickListener {
            operandWorker("/")
        }
    }

    private fun btnPow() {
        btn_pow.setOnClickListener {
            operandWorker("*")
        }
    }

    private fun btnPlus() {
        btn_plus.setOnClickListener {
            operandWorker("+")
        }
    }

    private fun btnMinus() {
        btn_minus.setOnClickListener {
            operandWorker("-")
        }
    }

    private fun operandWorker(type: String ) {
        default = result.text.toString()
        if (isDecimal(default.last())) {
            //если последний символ цифра
            if (enteredNumber == 0.0)  enteredNumber += lastNumber.toDouble()
            lastNumber = ""
        } else {
            default = default.dropLast(1)
        }
        default += type
        result.text = default
        operand = type
    }

    private fun btnAC() {
        btn_clear.setOnClickListener {
            enteredNumber = 0.0
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
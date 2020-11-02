package com.example.teacherkotlinproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var enteredNumber: Double = 0.0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""
    private val decimalArrayButtons = mutableListOf<Button>()
    private val operandArrayButtons = mutableListOf<Button>()

    //Создать новый массив для кнопок операндов.
    //В целых числах убрать дробное значение. (90 + 90 = 180)
    //Сократить длину результата при вычитании дробных чисел (4.529999999999999 -> 4.52) - ДОПОЛНИТЕЛЬНОЕ ЗАДАНИЕ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDecimalButtonsToArray()
        setOperandButtonsToArray()

        setDecimalButton()
        setOperandButton()

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

    private fun setDecimalButton() {
        for (btn in decimalArrayButtons) {
            btn.setOnClickListener {
                default = result.text.toString()
                default += btn.text
                lastNumber += btn.text
                result.text = default
            }
        }
    }

    private fun setOperandButtonsToArray() {
        operandArrayButtons.apply {
            add(btn_pow)
            add(btn_split)
            add(btn_minus)
            add(btn_plus)
        }
    }

    private fun setOperandButton() {
        for (btn in operandArrayButtons) {
            btn.setOnClickListener { operandWorker(btn.text.toString()) }
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

    private fun btnEquals() {
//        if (lastNumber.isNotEmpty())
        btn_equals.setOnClickListener {
            if (operand == "*") enteredNumber *= lastNumber.toDouble()
            else if (operand == "/") enteredNumber /= lastNumber.toDouble()
            else if (operand == "+") enteredNumber += lastNumber.toDouble()
            else if (operand == "-") enteredNumber -= lastNumber.toDouble()

            displayResult()
        }
    }

    private fun displayResult() {
        if (enteredNumber % 1 == 0.0) result.text = enteredNumber.roundToInt().toString()
        else result.text = String.format("%.2f", enteredNumber)
        lastNumber = ""
    }

    private fun operandWorker(type: String) {
        var text = result.text.toString()
        if (text.isNullOrEmpty()) { return }
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
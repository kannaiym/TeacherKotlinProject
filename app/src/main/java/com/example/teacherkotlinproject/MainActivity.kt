package com.example.teacherkotlinproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    //Типы кнопок
    // 1. просит от вас подтверждения - зеленый или приоритетный цвет приложение
    // 2. неактивный - серым неактивные, нужно сначала выполнить опредленное действие
    // 3. выключенные кнопки
    // 4. Второстепенные кнопки

    private var enteredNumber: Double = 0.0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""

    private val equalsArray = mutableListOf<String>()

    private val decimalArrayButtons = mutableListOf<Button>()
    private val operandArrayButtons = mutableListOf<Button>()

    //onRestart, onResume, onDestroy //onSaveInstanceState //onRestoreInstanceState
    //* Нужно обработать переворот вашего устройства и при этом сохранить значения: operand, enteredNumber, default, lastNumber
    //* Исправить отображение элементов в ListOfEqualsActivity
    //* В ListOfEqualsActivity отправлять только целые или дробные числа с 2 символоми после .

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
        btnOpenList()
    }

    private fun btnOpenList() {
        send_equal_btn.setOnClickListener {
            val intent = Intent(this, ListOfEqualsActivity::class.java)
            intent.putStringArrayListExtra("list", equalsArray as ArrayList<String>)
            startActivity(intent)
        }
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
        equalsArray.add(enteredNumber.toString())
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
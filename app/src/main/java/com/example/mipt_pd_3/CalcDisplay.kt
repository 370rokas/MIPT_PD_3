package com.example.mipt_pd_3;

import android.widget.TextView;

class CalcDisplay(private val displayText: TextView) {
    var currentNumberStr: String = "0"
    var startNew = false

    init {
        set("0")
    }

    fun set(target: String) {
        currentNumberStr = target
        displayText.text = currentNumberStr
    }

    fun add(newText: String) {
        if (startNew || currentNumberStr == "0") {
            currentNumberStr = newText
            startNew = false
        } else {
            currentNumberStr += newText
        }
        displayText.text = currentNumberStr
    }


    fun pop() {
        val result = currentNumberStr.dropLast(1)

        if (result.isEmpty() || result == "-") {
            set("0")
        } else {
            set(result)
        }
    }

    fun getNumber(): Double {
        return currentNumberStr.toDoubleOrNull() ?: 0.0
    }

    fun negate() {
        if (currentNumberStr == "0") return

        if (currentNumberStr.startsWith("-")) {
            set(currentNumberStr.drop(1))
        } else {
            set("-$currentNumberStr")
        }
    }

    fun addDot() {
        if (startNew) {
            startNew = false
            set("0.")
            return
        }

        if (currentNumberStr.contains(".")) return
        set("$currentNumberStr.")
    }

    fun setNumber(value: Double) {
        if (value.isNaN() || value.isInfinite()) {
            set("Error")
        } else if (value % 1.0 == 0.0 && kotlin.math.abs(value) < 1e15) {
            set(value.toLong().toString())
        } else {
            set(value.toString())
        }
    }
}
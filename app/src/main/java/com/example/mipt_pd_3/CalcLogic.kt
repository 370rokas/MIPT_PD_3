package com.example.mipt_pd_3

class CalcLogic(private val display: CalcDisplay) {
    var firstNumber: Double? = null
    var pendingOp: String? = null

    fun calculate(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b == 0.0) Double.NaN else a / b
            else -> b
        }
    }

    fun onOperator(op: String) {
        if (pendingOp != null && !display.startNew) {
            firstNumber = calculate(firstNumber!!, display.getNumber(), pendingOp!!)
            display.setNumber(firstNumber!!)

        } else {
            firstNumber = display.getNumber()
        }

        pendingOp = op
        display.startNew = true
    }

    fun onEquals() {
        if (pendingOp == null) return

        display.setNumber(calculate(firstNumber!!, display.getNumber(), pendingOp!!))

        firstNumber = null
        pendingOp = null
        display.startNew = true
    }

    fun clear() {
        firstNumber = null
        pendingOp = null
        display.set("0")
    }
}
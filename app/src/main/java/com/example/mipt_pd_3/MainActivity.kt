package com.example.mipt_pd_3

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val display = CalcDisplay(findViewById(R.id.displayText))
        val logic = CalcLogic(display)

        // CE
        val btnCE = findViewById<Button>(R.id.btnCE)
        btnCE.setOnClickListener {
            display.set("0")
        }

        // C
        val btnC = findViewById<Button>(R.id.btnC)
        btnC.setOnClickListener {
            logic.clear()
        }

        // Arrow aka pop last symbol
        val btnArrow = findViewById<Button>(R.id.btnArrow)
        btnArrow.setOnClickListener {
            display.pop()
        }

        // Plus Minus aka negate
        val btnPlusMinus = findViewById<Button>(R.id.btnPlusMinus)
        btnPlusMinus.setOnClickListener {
            display.negate()
        }

        // Numbers
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            display.add("1")
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            display.add("2")
        }

        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            display.add("3")
        }

        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener {
            display.add("4")
        }

        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener {
            display.add("5")
        }

        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener {
            display.add("6")
        }

        val btn7 = findViewById<Button>(R.id.btn7)
        btn7.setOnClickListener {
            display.add("7")
        }

        val btn8 = findViewById<Button>(R.id.btn8)
        btn8.setOnClickListener {
            display.add("8")
        }

        val btn9 = findViewById<Button>(R.id.btn9)
        btn9.setOnClickListener {
            display.add("9")
        }

        val btn0 = findViewById<Button>(R.id.btn0)
        btn0.setOnClickListener {
            display.add("0")
        }

        // dot aka trupmenine dalis
        val btnDot = findViewById<Button>(R.id.btnDot)
        btnDot.setOnClickListener {
            display.addDot()
        }

        // Zenklu operacijos
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        btnPlus.setOnClickListener {
            logic.onOperator("+")
        }

        val btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMinus.setOnClickListener {
            logic.onOperator("-")
        }

        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnMultiply.setOnClickListener {
            logic.onOperator("*")
        }

        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnDivide.setOnClickListener {
            logic.onOperator("/")
        }

        val btnEquals = findViewById<Button>(R.id.btnEquals)
        btnEquals.setOnClickListener {
            logic.onEquals()
        }

        val btnSqrt = findViewById<Button>(R.id.btnSqrt)
        btnSqrt.setOnClickListener {
            display.setNumber(kotlin.math.sqrt(display.getNumber()))
            display.startNew = true
        }

        val btnTrupmena = findViewById<Button>(R.id.btnTrupmena)
        btnTrupmena.setOnClickListener {
            val n = display.getNumber()
            display.setNumber(if (n == 0.0) Double.NaN else 1 / n)
            display.startNew = true
        }

        val btnPercent = findViewById<Button>(R.id.btnPercent)
        btnPercent.setOnClickListener {
            display.setNumber(display.getNumber() / 100)
            display.startNew = true
        }
    }
}
package com.renzo.calculadoralab02

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView

    private var current = ""
    private var operador = ""
    private var valor1 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.tvDisplay)
        val grid = findViewById<GridLayout>(R.id.grid)

        for (i in 0 until grid.childCount) {
            val btn = grid.getChildAt(i) as Button

            btn.setOnClickListener {
                val texto = btn.text.toString()
                manejarEntrada(texto)
            }
        }
    }

    private fun manejarEntrada(input: String) {
        when (input) {

            "0","1","2","3","4","5","6","7","8","9" -> {
                current += input
                display.text = current
            }

            "+","-","*","/" -> {
                if (current.isNotEmpty()) {
                    valor1 = current.toDouble()
                    operador = input
                    current = ""
                }
            }

            "=" -> {
                if (current.isNotEmpty()) {
                    val valor2 = current.toDouble()
                    val resultado = calcular(valor1, valor2, operador)
                    display.text = resultado.toString()
                    current = resultado.toString()
                }
            }

            "C" -> {
                current = ""
                operador = ""
                valor1 = 0.0
                display.text = "0"
            }
        }
    }

    private fun calcular(a: Double, b: Double, op: String): Double {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else 0.0
            else -> 0.0
        }
    }
}
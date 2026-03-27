package com.renzo.lab02moneda

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val radioDolares = findViewById<RadioButton>(R.id.radioDolares)
        val radioSoles = findViewById<RadioButton>(R.id.radioSoles)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val tipoCambio = 3.80  // puedes cambiarlo

        btnConvertir.setOnClickListener {
            val texto = etCantidad.text.toString()

            if (texto.isEmpty()) {
                tvResultado.text = "Ingrese un valor"
                return@setOnClickListener
            }

            val cantidad = texto.toDouble()
            var resultado: Double

            if (radioDolares.isChecked) {
                // Soles a dólares
                resultado = cantidad / tipoCambio
                tvResultado.text = "USD: %.2f".format(resultado)
            } else {
                // Dólares a soles
                resultado = cantidad * tipoCambio
                tvResultado.text = "PEN: %.2f".format(resultado)
            }
        }
    }
}
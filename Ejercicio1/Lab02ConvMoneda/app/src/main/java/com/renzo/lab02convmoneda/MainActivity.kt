package com.renzo.lab02convmoneda

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val tasas = mapOf(
        "USD" to 1.0,
        "PEN" to 3.80,
        "EUR" to 0.92,
        "GBP" to 0.78,
        "INR" to 83.0,
        "BRL" to 5.0,
        "MXN" to 17.0,
        "CNY" to 7.2,
        "JPY" to 150.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val spinnerOrigen = findViewById<Spinner>(R.id.spinnerOrigen)
        val spinnerDestino = findViewById<Spinner>(R.id.spinnerDestino)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val monedas = tasas.keys.toList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter

        btnConvertir.setOnClickListener {
            val texto = etCantidad.text.toString()

            if (texto.isEmpty()) {
                tvResultado.text = "Ingrese un valor"
                return@setOnClickListener
            }

            val cantidad = texto.toDouble()
            val origen = spinnerOrigen.selectedItem.toString()
            val destino = spinnerDestino.selectedItem.toString()

            val tasaOrigen = tasas[origen]!!
            val tasaDestino = tasas[destino]!!

            val resultado = (cantidad / tasaOrigen) * tasaDestino

            tvResultado.text = "Resultado: %.2f $destino".format(resultado)
        }
    }
}
package com.renzo.pizzalab02

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)

        val nombres = arrayOf(
            "Hawaiana",
            "Pepperoni",
            "Vegetariana",
            "Cuatro Quesos"
        )

        val imagenes = intArrayOf(
            R.drawable.pizza1,
            R.drawable.pizza2,
            R.drawable.pizza3,
            R.drawable.pizza4
        )

        val adapter = PizzaAdapter(this, nombres, imagenes)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, nombres[position], Toast.LENGTH_SHORT).show()
        }
    }
}
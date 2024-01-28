package com.example.botonesdeantonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val numBotones = 20
    private lateinit var llBotonera: LinearLayout
    private var indiceBotonEspecial: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBotonera = findViewById(R.id.llBotonera)

        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_height)
        )

        indiceBotonEspecial = Random.nextInt(numBotones)
        for (i in 0 until numBotones) {
            val button = Button(this)
            button.layoutParams = lp
            button.text = "Botón " + String.format("%02d", i)
            button.setOnClickListener(buttonClickListener(i))
            llBotonera.addView(button)

        }
    }

    private fun buttonClickListener(index: Int): View.OnClickListener? {
        return View.OnClickListener {
            if (index == indiceBotonEspecial) {
                mostrarMensaje("ME ENCONTRASTE!!")
            } else {
                mostrarMensaje("Sigue buscando")
            }
        }
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(
            this@MainActivity,
            mensaje,
            Toast.LENGTH_SHORT
        ).show()
    }
}
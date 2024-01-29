package com.example.ventanasdeantonio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaludoActivity : AppCompatActivity() {

    private lateinit var txtSaludo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        txtSaludo = findViewById(R.id.txtSaludo)

        val bundle = intent.extras

        txtSaludo.text = "Hola ${bundle?.getString("NOMBRE")}"
    }
}
package com.example.ventanasdeantonio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var btnAceptar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre = findViewById(R.id.txtNombre)
        btnAceptar = findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener{
            val intent = Intent(this@MainActivity, SaludoActivity::class.java)

            val b = Bundle()
            b.putString("NOMBRE",txtNombre.text.toString())

            intent.putExtras(b)

            startActivity(intent)
        }
    }
}
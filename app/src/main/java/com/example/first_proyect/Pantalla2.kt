package com.example.first_proyect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnr: Button = findViewById(R.id.registerButton)
        btnr.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla3::class.java)
            startActivity(intent)
        }
        val btna: Button = findViewById(R.id.accederButton)
        btna.setOnClickListener{
            val intent: Intent = Intent(this, Sistema_P::class.java)
            startActivity(intent)
        }

    }
}
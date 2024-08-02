package com.example.first_proyect

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.common.internal.Constants



class Pantalla2 : AppCompatActivity() {
    object Constants {
        const val USUARIO = "admin"
        const val CONTRASEÑA = "password123"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla2)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<EditText>(R.id.nickname)
        val etPassword = findViewById<EditText>(R.id.password)
        val btnLogin:Button = findViewById(R.id.accederButton)
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == Constants.USUARIO && password == Constants.CONTRASEÑA) {
                val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("LOGGED_IN", true).apply()
                val intent = Intent(this, Sistema_P::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
        val btnr: Button = findViewById(R.id.registerButton)
        btnr.setOnClickListener{
            val intent: Intent = Intent(this, Pantalla3::class.java)
            startActivity(intent)
        }

        val openLinkImageButton: ImageButton = findViewById(R.id.whatsappIcon)
        openLinkImageButton.setOnClickListener {
            val url = "https://wa.link/pw8w8g"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        val openLinkImageButtona: ImageButton = findViewById(R.id.githubIcon)
        openLinkImageButtona.setOnClickListener {
            val url = "https://github.com/R0s4l3s/first_proyect"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        val openLinkImageButtonb: ImageButton = findViewById(R.id.twitterIcon)
        openLinkImageButtonb.setOnClickListener {
            val url = "https://x.com/MrB14ck"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
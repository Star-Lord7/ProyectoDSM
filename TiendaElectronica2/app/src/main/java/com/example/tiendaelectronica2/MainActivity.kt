package com.example.tiendaelectronica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val logoutButton = findViewById<Button>(R.id.logoutButton)

        logoutButton.setOnClickListener {
            auth.signOut()
            // Redirigir al Login después de cerrar sesión
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Cierra la actividad actual para que no se pueda volver atrás
        }
    }
}
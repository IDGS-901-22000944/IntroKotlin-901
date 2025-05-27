package org.utl.dsm505.introkotlin_901

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.ejemplo1.SumaActivity
import org.utl.dsm505.introkotlin_901.ejemplo2.SaludoActivity
import org.utl.dsm505.introkotlin_901.practica.CinepolisActivity
import org.utl.dsm505.introkotlin_901.practicaDiccionario.InicioActivity


class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_menu)
        val btnSaludo = findViewById<Button>(R.id.btn1)
        btnSaludo.setOnClickListener{ navegateToSaludo()}


        val btnCine = findViewById<Button>(R.id.btn2)
        btnCine.setOnClickListener{ navegateToCinepolis()}

        val btnSaludo2 = findViewById<Button>(R.id.btn3)
        btnSaludo2.setOnClickListener{ navegateToSaludos()}

        val diccionario = findViewById<Button>(R.id.btn4)
        diccionario.setOnClickListener{ navegateToDiccionario()}





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnGuardarCap)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludos() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToDiccionario() {
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)
    }



}
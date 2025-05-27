package org.utl.dsm505.introkotlin_901.practicaDiccionario

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R

class InicioActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)


        val btncap = findViewById<Button>(R.id.butn1Inicio)
        btncap.setOnClickListener{ navegateToCapturar()}


        val btnCine = findViewById<Button>(R.id.butn2Inicio)
        btnCine.setOnClickListener{ navegateToBuscar()}




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToCapturar() {
        val intent = Intent(this, CapturarActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToBuscar() {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }



}
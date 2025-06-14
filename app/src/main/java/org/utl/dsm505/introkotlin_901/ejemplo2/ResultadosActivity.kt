package org.utl.dsm505.introkotlin_901.ejemplo2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultados)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name: String=intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text="Hola $name"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnGuardarCap)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
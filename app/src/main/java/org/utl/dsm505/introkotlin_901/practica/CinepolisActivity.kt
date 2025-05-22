package org.utl.dsm505.introkotlin_901.practica

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R

class CinepolisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        val btnCalcular: Button = findViewById(R.id.Calcular)
        val etNombre: EditText = findViewById(R.id.Nombre)
        val etCompradores: EditText = findViewById(R.id.Compradores)
        val etBoletos: EditText = findViewById(R.id.Boletos)
        val rgTarjeta: RadioGroup = findViewById(R.id.Tarjeta)
        val tvTotal: TextView = findViewById(R.id.Total)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnCalcular.setOnClickListener {
            if (etNombre.text.isEmpty() || etCompradores.text.isEmpty() || etBoletos.text.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nombre = etNombre.text.toString()
            val compradores = etCompradores.text.toString().toInt()
            val boletos = etBoletos.text.toString().toInt()
            val tieneTarjeta = rgTarjeta.checkedRadioButtonId == R.id.radioSi

            val maxBoletosPorPersona = 7
            if (boletos > compradores * maxBoletosPorPersona) {
                Toast.makeText(this, "No se pueden comprar más de $maxBoletosPorPersona boletos por persona", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calcular el total
            val precioBoleto = 12.0
            var total = boletos * precioBoleto

            // Aplicar descuento
            if (boletos in 3..5) {
                total *= 0.9 // 10% de descuento
            } else if (boletos > 5) {
                total *= 0.85 // 15% de descuento
            }

            // Aplicar descuento adicional por tarjeta Cineco (10%)
            if (tieneTarjeta) {
                total *= 0.9
            }

            tvTotal.text = "$${"%.2f".format(total)}"


            Toast.makeText(this, "Gracias por su compra, $nombre", Toast.LENGTH_SHORT).show()
        }







    }








}
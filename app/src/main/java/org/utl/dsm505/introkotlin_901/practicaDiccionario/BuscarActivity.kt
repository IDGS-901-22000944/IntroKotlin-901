package org.utl.dsm505.introkotlin_901.practicaDiccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        val radioEspanol = findViewById<RadioButton>(R.id.radioEspanol)
        val radioIngles = findViewById<RadioButton>(R.id.radioIngles)
        val editPalabra = findViewById<EditText>(R.id.editPalabra)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val textView8 = findViewById<TextView>(R.id.textView8)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)


        textView8.visibility = TextView.INVISIBLE
        txtResultado.visibility = TextView.INVISIBLE



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnGuardarCap)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnBuscar.setOnClickListener {
            val palabraABuscar = editPalabra.text.toString().trim()

            if (palabraABuscar.isEmpty()) {
                Toast.makeText(this, "Ingresa una palabra para buscar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val buscarEnEspanol = radioEspanol.isChecked
            val resultado = buscarPalabra(palabraABuscar, buscarEnEspanol)

            if (resultado != null) {

                textView8.visibility = TextView.VISIBLE
                textView8.text = "Palabra encontrada"
                txtResultado.visibility = TextView.VISIBLE
                txtResultado.text = resultado
            } else {

                textView8.visibility = TextView.VISIBLE
                textView8.text = "Palabra no encontrada"
                txtResultado.visibility = TextView.INVISIBLE
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun buscarPalabra(palabra: String, buscarEnEspanol: Boolean): String? {
        return try {

            val fis = openFileInput("diccionario.txt")
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)

            var linea: String?
            var resultado: String? = null


            while (br.readLine().also { linea = it } != null) {
                val partes = linea?.split(",")
                if (partes != null && partes.size == 2) {
                    val espanol = partes[0].trim()
                    val ingles = partes[1].trim()

                    if (buscarEnEspanol) {

                        if (ingles.equals(palabra, ignoreCase = true)) {
                            resultado = espanol
                            break
                        }
                    } else {

                        if (espanol.equals(palabra, ignoreCase = true)) {
                            resultado = ingles
                            break
                        }
                    }
                }
            }

            br.close()
            isr.close()
            fis.close()

            resultado
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show()
            null
        }
    }
}




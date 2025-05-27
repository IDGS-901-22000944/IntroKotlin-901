package org.utl.dsm505.introkotlin_901.practicaDiccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import android.content.Context
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R
import java.io.FileOutputStream

class CapturarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)

        val editEspanol = findViewById<EditText>(R.id.editTextText)
        val editIngles = findViewById<EditText>(R.id.editTextText2)
        val btnGuardar = findViewById<Button>(R.id.button)
        val btnRegresar = findViewById<Button>(R.id.button2)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnGuardarCap)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Acción para el botón Guardar
        btnGuardar.setOnClickListener {
            val palabraEspanol = editEspanol.text.toString().trim()
            val palabraIngles = editIngles.text.toString().trim()

            if (palabraEspanol.isEmpty() || palabraIngles.isEmpty()) {
                Toast.makeText(this, "Ambos campos son requeridos", Toast.LENGTH_SHORT).show()
            } else {
                guardarParPalabras(palabraEspanol, palabraIngles)
                mostrarAlertaExito()
                editEspanol.text.clear()
                editIngles.text.clear()
            }
        }

        // Acción para el botón Regresar
        btnRegresar.setOnClickListener {
            finish() // Cierra esta actividad y regresa al menú anterior
        }
    }

    fun guardarParPalabras(espanol: String, ingles: String) {
        val linea = "$espanol,$ingles\n" // Formato: palabra1,palabra2
        try {
            // Abre el archivo en modo append (para agregar sin borrar lo existente)
            val fos: FileOutputStream = openFileOutput("diccionario.txt", Context.MODE_APPEND)
            fos.write(linea.toByteArray())
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
        }
    }

    fun mostrarAlertaExito() {
        AlertDialog.Builder(this)
            .setTitle("Éxito")
            .setMessage("Las palabras se han almacenado correctamente")
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()






    }
}
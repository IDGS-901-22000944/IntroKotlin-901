package org.utl.dsm505.introkotlin_901.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm505.introkotlin_901.R

class SumaActivity : AppCompatActivity() {
    private lateinit var et1:EditText
    private lateinit var et2:EditText
    private lateinit var tv1:TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButtonSuma: RadioButton
    private lateinit var radioButtonResta: RadioButton
    private lateinit var radioButtonMultiplicar: RadioButton
    private lateinit var radioButtonDividir: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioGroup = findViewById(R.id.radioGroup)
        radioButtonSuma = findViewById(R.id.radioButtonSuma)
        radioButtonResta = findViewById(R.id.radioButtonResta)
        radioButtonMultiplicar = findViewById(R.id.radioButtonMultiplicar)
        radioButtonDividir = findViewById(R.id.radioButtonDividir)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnGuardarCap)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View){
        if (et1.text.isEmpty() || et2.text.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()
        var resultado = 0.0

        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButtonSuma -> resultado = num1 + num2
            R.id.radioButtonResta -> resultado = num1 - num2
            R.id.radioButtonMultiplicar -> resultado = num1 * num2
            R.id.radioButtonDividir -> {
                if (num2 != 0.0) {
                    resultado = num1 / num2
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> {
                Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show()
                return
            }
        }

        tv1.text = "Resultado = %.2f".format(resultado)
    }




}
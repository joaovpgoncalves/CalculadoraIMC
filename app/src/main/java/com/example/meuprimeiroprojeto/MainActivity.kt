package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalcular: Button = findViewById(R.id.btncalcular)
        val edtPeso: EditText = findViewById(R.id.edt_Peso)
        val edtAltura: EditText = findViewById(R.id.edt_Altura)

        btncalcular.setOnClickListener {

            val AlturaStr = edtAltura.text.toString()
            val PesoStr = edtPeso.text.toString()

            if (AlturaStr.isNotEmpty() && PesoStr.isNotEmpty()){
                val altura: Float = AlturaStr.toFloat()
                val peso: Float = PesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val pesoFinal: Float = peso

                val result: Float = pesoFinal / alturaFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()

            }
        }
    }}
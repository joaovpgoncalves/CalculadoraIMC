        package com.example.meuprimeiroprojeto

        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle
        import android.view.MenuItem
        import android.widget.TextView

        @Suppress("UNUSED_EXPRESSION")
        class ResultActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f)
            "Magreza"
        else if (result in 18.5f..24.9f)
            "Normal"
        else if (result in 25.0f..29.9f)
            "Sobrepeso"
        else if (result in 30.0f..34.9f)
            "Obesidade grau I"
        else if (result in 35.0f..39.9f)
            "Obesidade grau II"
        else
            "Obesidade grau III"

        tvClassificacao.text = getString(R.string.message_classificação, classificacao)

        }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
        }

        }
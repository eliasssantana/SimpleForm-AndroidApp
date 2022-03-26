package com.example.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nomeDigitado = intent.getStringExtra("NOME_DIGITADO")

        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvResult.text = nomeDigitado
    }
}
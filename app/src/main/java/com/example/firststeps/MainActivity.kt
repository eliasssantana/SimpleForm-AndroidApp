package com.example.firststeps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.tvTitle)
        val btn = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)
        val etNome = findViewById<EditText>(R.id.etName)
        btn.setOnClickListener {
            if(etNome.text.isNotBlank()){
                title.text = getString(R.string.say_hello, etNome.text.toString())
                etNome.text.clear()
            }else{
                etNome.error = getString(R.string.error_message)
            }
        }

        btn2.setOnClickListener {
            if(etNome.text.isNotBlank()){
                val nomeDigitado = etNome.text.toString()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("NOME_DIGITADO", nomeDigitado)
                startActivity(intent)
            }else{
                etNome.error = getString(R.string.error_message)
            }
        }

    }
}
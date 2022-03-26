package com.example.firststeps

import android.app.Activity
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
        val btn3 = findViewById<Button>(R.id.button3)
        val etNome = findViewById<EditText>(R.id.etName)
        btn.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                title.text = getString(R.string.say_hello, etNome.text.toString())
                etNome.text.clear()
            } else {
                etNome.error = getString(R.string.error_message)
            }
        }

        btn2.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                val nomeDigitado = etNome.text.toString()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("NOME_DIGITADO", nomeDigitado)
                startActivity(intent)
            } else {
                etNome.error = getString(R.string.error_message)
            }
        }

        btn3.setOnClickListener {
            val intent = Intent(this, SendResultActivity::class.java)
            val requestCode = 1

            //deprecado. Procura o nova forma de se fazer isso
            startActivityForResult(intent, requestCode)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("RESULT")

                val title = findViewById<TextView>(R.id.tvTitle)
                title.text = getString(R.string.data_received, result)
            }else if(resultCode == Activity.RESULT_CANCELED){
                val title = findViewById<TextView>(R.id.tvTitle)
                title.text = getString(R.string.screen_canceled)
            }
        }
    }
}
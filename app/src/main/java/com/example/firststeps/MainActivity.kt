package com.example.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var title = findViewById<TextView>(R.id.tvTitle)
        var btn = findViewById<Button>(R.id.button)
        val etNome = findViewById<EditText>(R.id.etName)
        btn.setOnClickListener {
            if(etNome.text.isNotBlank()){
                title.text = getString(R.string.say_hello, etNome.text.toString())
                etNome.text.clear()
            }else{
                etNome.error = getString(R.string.error_message)
            }
        }

    }
}
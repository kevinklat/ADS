package br.uniasselvi.primeiroapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtNum1 = findViewById<EditText>(R.id.edt_num1)
        val edtNum2 = findViewById<EditText>(R.id.edt_num2)
        val btnSoma = findViewById<Button>(R.id.btn_somar)
        btnSoma.setOnClickListener {
            val valorN1 = edtNum1.text.toString().toInt()
            val valorN2 = edtNum2.text.toString().toInt()
            val soma = valorN1+valorN2

            Toast.makeText(this, "$soma", Toast.LENGTH_SHORT).show()
        }
    }
}
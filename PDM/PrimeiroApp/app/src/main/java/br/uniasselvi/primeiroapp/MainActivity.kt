package br.uniasselvi.primeiroapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
//import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val lista = mutableListOf<String>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        //val edtNum2 = findViewById<EditText>(R.id.edt_num2)
        val btnCad = findViewById<Button>(R.id.btn_cadastrar)
        btnCad.setOnClickListener {
            val valorNome = edtNome.text.toString()
            lista.add(valorNome)
            Log.i("lista", lista.get(0))



           // val valorN2 = edtNum2.text.toString().toInt()
            //val soma = valorN1+valorN2
            //Toast.makeText(this, "$soma", Toast.LENGTH_SHORT).show()
        }
    }
}
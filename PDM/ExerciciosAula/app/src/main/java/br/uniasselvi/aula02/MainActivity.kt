package br.uniasselvi.aula02

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edt_1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnTeste = findViewById<Button>(R.id.btn_teste)

        btnTeste.setOnClickListener {
            Toast.makeText(this, "Numeros"+sortearNumeros(),
                Toast.LENGTH_SHORT).show()

        }

    }
    fun sortearNumeros():Set<Int> {

    val numerosSorteados = mutableSetOf<Int>()
        while(numerosSorteados.size < 6){
            val numeros = Random.nextInt(1, 60)
            numerosSorteados.add(numeros)

        }

        return numerosSorteados

    }
}
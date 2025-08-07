package br.uniasselvi.exerciciosaula02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edUsername = findViewById<EditText>(R.id.ed_username)
        val edPassword = findViewById<EditText>(R.id.ed_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {

            val username = edUsername.text.toString()
            val password = edPassword.text.toString()
            if (username == "admin" && password == "admin") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Invalido!",
                    Toast.LENGTH_LONG).show()
            }

        }

    }
}
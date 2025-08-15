package com.aula.aula3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edUsername = findViewById<EditText>(R.id.et_username)
        val edPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {

            val username = edUsername.text.toString()
            val password = edPassword.text.toString()
/*
            if (username == "admin" && password == "admin"){

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Credencial inválida!!!!",
                    Toast.LENGTH_LONG).show()

            }
*/
            realizarLogin(username, password)

        }


    }



    private fun realizarLogin(username: String, password: String) {
        val url = "http://192.168.0.42:8080/api/login"
        val client = OkHttpClient()
        val jsonObject = JSONObject()
        jsonObject.put("usuario", username)
        jsonObject.put("password", password)

        val body = RequestBody.create(
            "application/json; charset=utf-8".toMediaTypeOrNull(),
            jsonObject.toString()
        )

        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "Erro na solicitação" + e.message, Toast.LENGTH_SHORT)
                        .show()
                }
                Log.e("LoginActivity", "Erro na solicitação", e)
            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {
                    if (response.isSuccessful) {
                        val intent = Intent(this@MainActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Credenciais inválidas",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


            }
        })
    }






}
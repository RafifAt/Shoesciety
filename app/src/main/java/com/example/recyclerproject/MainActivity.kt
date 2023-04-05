package com.example.recyclerproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


private lateinit var username: EditText
private lateinit var password: EditText
private lateinit var btnLogin: Button
private lateinit var register: TextView

private val EMAIL = "HOOH"
private val PASS = "123"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        username = findViewById<EditText>(R.id.etUsername)
        password = findViewById<EditText>(R.id.etPassword)
        btnLogin = findViewById<Button>(R.id.btnLogin)

        val btnMoveActivity: TextView =
            findViewById(R.id.register_oke)
        btnMoveActivity.setOnClickListener(this)


        btnLogin.setOnClickListener {
            try {
                val Email = username.text.toString()
                val Pass = password.text.toString()
                if (Email.isNotBlank() && Pass.isNotBlank()) {
                    val i = Intent(this, ShoesActivity::class.java)
                    i.putExtra(EMAIL, Email)
                    i.putExtra(PASS, Pass)
                    startActivity(i)
                } else {
                    Toast.makeText(applicationContext, "PLEASE INPUT EMAIL", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: Exception) {

                e.printStackTrace()
                Toast.makeText(applicationContext, "ERROR, TRY AGAIN", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.register_oke -> {
                val moveIntent = Intent(this@MainActivity, RegisterForm::class.java)
                startActivity(moveIntent)
            }
        }
    }


    }

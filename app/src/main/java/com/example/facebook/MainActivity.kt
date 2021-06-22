package com.example.facebook

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener() {

            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString("EMAIL", email)
            editor.putString("PASSWORD", password)
            editor.apply()

            if (email.equals("silambu.kvs12@gmail.com") && password.equals("simbu123")) {

                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }

            else {
                Toast.makeText(this, "Wrong email address or password", Toast.LENGTH_SHORT).show()
            }

        }

        btnSignup.setOnClickListener() {

            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}
package com.example.chatverse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val signup:TextView = findViewById(R.id.signup_textview_login)
        signup.setOnClickListener{
            Log.d("LoginActivity", "Trying to show signup activity")
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            Log.d("SignupActivity","Sign up page successfully shown")
        }


        findViewById<Button>(R.id.login_button_login).setOnClickListener{
            val username = findViewById<EditText>(R.id.username_edittext_login).text.toString()
            val password = findViewById<EditText>(R.id.password_edittext_login).text.toString()

            Log.d("LoginActivity", "Username/Mobile Number is: $username")
            Log.d("LoginActivity", "Password is: $password")
        }











    }
}
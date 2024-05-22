package com.example.chatverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn: Button = findViewById(R.id.login_button)
        loginBtn.setOnClickListener{
            Log.d("MainActitvity", "Trying to show Login activity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            Log.d("LoginActivity", "login page successfully shown")

        }

        val signupBtn: Button = findViewById(R.id.signupButton)
        signupBtn.setOnClickListener{
            Log.d("MainActivity", "Trying to show signup activity")
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            Log.d("SignupActivity","signup page successfully shown")

        }







            



    }
}
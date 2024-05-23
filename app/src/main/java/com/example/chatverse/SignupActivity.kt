package com.example.chatverse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup);

        val login:TextView = findViewById(R.id.login_textview_signup)
        login.setOnClickListener{
            Log.d("SignupActivity","Trying to show login activity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            Log.d("LoginActivity","Login page successfully shown")
        }

        findViewById<Button>(R.id.signup_button_signup).setOnClickListener{
            val username = findViewById<EditText>(R.id.username_edittext_signup).text.toString()
            val mobileno = findViewById<EditText>(R.id.mobileno_edittext_signup).text.toString()
            val password = findViewById<EditText>(R.id.password_edittext_signup).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.confirmPassword_edittext_signup).text.toString()

            Log.d("SignupActivity","Username is: $username")
            Log.d("SignupActivity","Mobile no is: $mobileno")
            Log.d("SignupActivity","Password is: $password")
            Log.d("SignupActivity","Confirm password is: $confirmPassword")
        }
    }


}
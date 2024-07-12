package com.minalghate.chatverse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        //Clicking Login button
        findViewById<Button>(R.id.login_button_login).setOnClickListener{
            performLoginRegister()
        }

        //Clicking Don't have an account signup textview
        val signup:TextView = findViewById(R.id.signup_textview_login)
        signup.setOnClickListener{
            Log.d("LoginActivity", "Trying to show signup activity")
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
            Log.d("SignupActivity","Sign up page successfully shown")
        }

    }

    private fun performLoginRegister() {
        //textfield value accessing
        val email = findViewById<EditText>(R.id.username_edittext_signup).text.toString()
        val password = findViewById<EditText>(R.id.password_edittext_signup).text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("LoginActivity", "email is: $email")
        Log.d("LoginActivity", "Password is: $password")



        //Firebase authentication
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                //unsuccessful login
                if(!it.isSuccessful) return@addOnCompleteListener
                //for successful login
                Log.d("LoginActivity","Successfully logged in ${it.result.user?.uid}")


            }
            .addOnFailureListener{
                Log.d("LoginActivity","Failed to logging in user ${it.message}")
                Toast.makeText(this,"Failed to logging in user ${it.message}",Toast.LENGTH_SHORT).show()
            }


    }


}
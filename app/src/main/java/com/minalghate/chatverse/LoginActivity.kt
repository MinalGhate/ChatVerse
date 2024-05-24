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
        val usernameEmail = findViewById<EditText>(R.id.username_edittext_login).text.toString()
        val password = findViewById<EditText>(R.id.password_edittext_login).text.toString()

        if(usernameEmail.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("LoginActivity", "Username/Mobile Number is: $usernameEmail")
        Log.d("LoginActivity", "Password is: $password")



        //Firebase authentication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(usernameEmail,password)
            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener
                //else if successful
                Log.d("LoginActivity", "Successfully created user with uid: ${it.result.user?.uid}")
            }
            .addOnFailureListener{
                Log.d("LoginActivity","Failed to create user: ${it.message}")
                Toast.makeText(this,"Enter correct Email id and password", Toast.LENGTH_SHORT).show()

            }

    }


}
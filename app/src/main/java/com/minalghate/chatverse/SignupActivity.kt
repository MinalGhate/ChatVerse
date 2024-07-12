package com.minalghate.chatverse

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.selects.select

class SignupActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup);

        //clicking signup button
        findViewById<Button>(R.id.signup_button_signup).setOnClickListener{
            //accessing text field information
            newUser();
            val intent = Intent(this, MessageDashboardActivity::class.java)
            //clearing all activity in stack
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }

        //clicking already have an account login
        val login:TextView = findViewById(R.id.login_textview_signup)
        login.setOnClickListener{
            Log.d("SignupActivity","Trying to show login activity")
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            Log.d("LoginActivity","Login page successfully shown")
        }

//        findViewById<Button>(R.id.selectphoto_button).setOnClickListener{
//            Log.d("SignupActivity","Trying to add image")
//
//            val intent = Intent(Intent.ACTION_PICK)
//            intent.type = "image/*"
//            startActivityForResult(intent,0)
//
//        }



    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==0 && resultCode == Activity.RESULT_OK && data!=null){
//            //to check image
//            Log.d("SignupActivity","Photo is selected")
//            val uri = data.data
//
//            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
//
//            val bitmapDrawable = BitmapDrawable(bitmap)
//            findViewById<Button>(R.id.selectphoto_button).setBackgroundDrawable(bitmapDrawable)
//        }
//    }

    private fun newUser(){
        val username = findViewById<EditText>(R.id.username_edittext_signup).text.toString()
        val email = findViewById<EditText>(R.id.email_edittext_signup).text.toString()
        val password = findViewById<EditText>(R.id.password_edittext_signup).text.toString()
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword_edittext_signup).text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter email and password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("SignupActivity","Username is: $username")
        Log.d("SignupActivity","Email id is: $email")
        Log.d("SignupActivity","Password is: $password")
        Log.d("SignupActivity","Confirm password is: $confirmPassword")

        //Firebase authentication
        var auth:FirebaseAuth = FirebaseAuth.getInstance()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                //if unsuccessful
                if(!it.isSuccessful) return@addOnCompleteListener
                //else if successful
                Log.d("SignupActivity", "Successfully created user with uid: ${it.result.user?.uid}")
            }
            .addOnFailureListener{
                Log.d("SignupActivity","Failed to create user: ${it.message}")
                Toast.makeText(this,"Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()

            }

    }


}
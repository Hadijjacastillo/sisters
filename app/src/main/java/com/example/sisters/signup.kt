package com.example.sisters

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth=FirebaseAuth.getInstance()
        val email1=findViewById<EditText>(R.id.signupemail)
        val password1=findViewById<EditText>(R.id.signuppassword)
        val button=findViewById<Button>(R.id.signupbutton)

     button.setOnClickListener{
         val email=email1.text.toString()
         val password=password1.text.toString()

         auth.createUserWithEmailAndPassword(email,password)
             .addOnCompleteListener(this){task->
                 if (task.isSuccessful){
                     startActivity(Intent(this,MainActivity::class.java))
                     Toast.makeText(
                         baseContext,
                         "sign is successful",
                         Toast.LENGTH_SHORT,
                         ).show()

                 }else{
                     Log.w(TAG,"CreateUserWithEmail:failure",task.exception)
                     Toast.makeText(
                         baseContext,
                         "sign is failed",
                         Toast.LENGTH_SHORT,
                     ).show()
                 }
             }
     }
        val alread=findViewById<TextView>(R.id.alreadys)
        alread.setOnClickListener{
            startActivity(Intent(this,login::class.java))
        }
    }
}
package com.example.sisters

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.contentValuesOf

import com.google.firebase.StartupTime
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        val email = findViewById<EditText>(R.id.loginemail)
        val password = findViewById<EditText>(R.id.passwordlogin)
        val button = findViewById<Button>(R.id.loginbutton)
        val sign = findViewById<Button>(R.id.sign)
        val already = findViewById<TextView>(R.id.textView3)

        button.setOnClickListener {
            val email1 = email.text.toString()
            val password1 = password.text.toString()

            auth.signInWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        Toast.makeText(
                            baseContext,
                            "login successful",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Log.w(ContentValues.TAG, "EmailUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            task.exception.toString(),
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }


        }

        sign.setOnClickListener{
            startActivity(Intent(this,signup::class.java))
        }

        already.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
    }
}
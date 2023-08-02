package com.example.sisters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Handler

class splash : AppCompatActivity() {
    private val splash = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        android.os.Handler().postDelayed({
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        },splash)



    }
}
package com.example.demo_mvvm.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_mvvm.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
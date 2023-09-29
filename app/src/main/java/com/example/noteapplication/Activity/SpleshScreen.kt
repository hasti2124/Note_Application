package com.example.noteapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapplication.databinding.ActivitySpleshScreenBinding

class SpleshScreen : AppCompatActivity() {
    lateinit var binding: ActivitySpleshScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpleshScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this@SpleshScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.tsu.catandactivityvisualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.catandactivityvisualnovel.databinding.ActivityEndGameBinding

class EndGame : AppCompatActivity() {
    private lateinit var binding: ActivityEndGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRepeat.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.tsu.catandactivityvisualnovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tsu.catandactivityvisualnovel.databinding.ActivityGamePlayBinding

class GamePlay : AppCompatActivity() {
    private lateinit var binding: ActivityGamePlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamePlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn1Hide = findViewById<Button>(R.id.btn2Choice)
        val btn2Hide = findViewById<Button>(R.id.btn2Choice2)
        val btn3Hide = findViewById<Button>(R.id.btn2Choice3)
        val btnAcceptHide = findViewById<Button>(R.id.btn2Accept)
        val InputHide = findViewById<TextView>(R.id.textInputName)
        val page = intent.getStringExtra(PageName.page).toString()

        when (page) {
            "2" -> {
                btn1Hide.visibility = View.GONE
                btn2Hide.visibility = View.GONE
                btn3Hide.visibility = View.GONE
                binding.text2Edit.text = getString(R.string.p2_hello)
            }
            "3" -> {
                InputHide.visibility = View.GONE
                btnAcceptHide.visibility = View.GONE
                val name = intent.getStringExtra(PageName.name).toString()
                binding.text2Edit.text = getString(R.string.p3_great, name)
            }
        }

        binding.btn2Accept.setOnClickListener {
            when (page) {
                "2" -> {
                    if (binding.textInputName.text != null) {
                        val intent = Intent(this, GamePlay::class.java)
                        intent.putExtra(PageName.name, binding.textInputName.text.toString())
                        intent.putExtra(PageName.page, "3")
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

        binding.btn2Choice.setOnClickListener {
            val intent = Intent(this, ScenarioPlay::class.java)
            intent.putExtra(PageName.page, "4")
            startActivity(intent)
            finish()
        }

        binding.btn2Choice2.setOnClickListener {
            val intent = Intent(this, ScenarioPlay::class.java)
            intent.putExtra(PageName.page, "5")
            startActivity(intent)
            finish()
        }

        binding.btn2Choice3.setOnClickListener {
            val intent = Intent(this, ScenarioPlay::class.java)
            intent.putExtra(PageName.page, "6")
            startActivity(intent)
            finish()
        }
    }
}
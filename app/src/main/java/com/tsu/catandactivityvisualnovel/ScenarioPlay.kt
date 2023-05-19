package com.tsu.catandactivityvisualnovel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tsu.catandactivityvisualnovel.databinding.ActivityScenarioPlayBinding

class ScenarioPlay : AppCompatActivity() {
    private lateinit var binding: ActivityScenarioPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScenarioPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val page = intent.getStringExtra(PageName.page).toString()
        val btnHide = findViewById<Button>(R.id.btn4Choice2)

        when (page) {
            "4" -> {
                //binding.layout.background = getDrawable(R.drawable.walking)
                binding.imgView2.setImageResource(R.drawable.walking)
                //imageView.setImageResource(R.drawable.walking)
                binding.text4Edit.text = getString(R.string.p4_question)
                binding.btn4Choice1.text = getString(R.string.p4_btn1)
                binding.btn4Choice2.text = getString(R.string.p4_btn2)
            }
            "5" -> {
                //binding.layout.background = getDrawable(R.drawable.hiking)
                binding.imgView2.setImageResource(R.drawable.hiking)
                //imageView.setImageResource(R.drawable.hiking)
                binding.text4Edit.text = getString(R.string.p5_question)
                binding.btn4Choice1.text = getString(R.string.p5_btn1)
                binding.btn4Choice2.text = getString(R.string.p5_btn2)
            }
            "6" -> {
                //binding.layout.background = getDrawable(R.drawable.field)
                binding.imgView2.setImageResource(R.drawable.field)
                //imageView.setImageResource(R.drawable.field)
                binding.text4Edit.text= getString(R.string.p6_question)
                binding.btn4Choice1.text = getString(R.string.p6_btn1)
                binding.btn4Choice2.text = getString(R.string.p6_btn2)
            }
            "7" -> {
                binding.imgView2.setImageResource(R.drawable.watching)
                binding.text4Edit.text = getString(R.string.p7_question)
                binding.btn4Choice1.text = getString(R.string.p7_btn1)
                binding.btn4Choice2.text = getString(R.string.p7_btn2)
            }
            "8" -> {
                binding.imgView2.setImageResource(R.drawable.helloween)
                binding.text4Edit.text = getString(R.string.p8_question)
                binding.btn4Choice1.text = getString(R.string.p8_btn1)
                binding.btn4Choice2.text = getString(R.string.p8_btn2)
            }
            "9" -> {
                btnHide.visibility = View.GONE
                binding.imgView2.setImageResource(R.drawable.watching)
                binding.text4Edit.text = getString(R.string.p9_question)
                binding.btn4Choice1.text = getString(R.string.p9_btn1)
                //binding.btn6Choice2.text = getString(R.string.p9_btn2)
            }
            "10" -> {
                btnHide.visibility = View.GONE
                binding.imgView2.setImageResource(R.drawable.watching)
                binding.text4Edit.text = getString(R.string.p10_question)
                binding.btn4Choice1.text = getString(R.string.p10_btn1)
                //binding.btn6Choice2.text = getString(R.string.p8_btn2)
            }
            "11" -> {
                binding.imgView2.setImageResource(R.drawable.costume)
                binding.text4Edit.text = getString(R.string.p11_question)
                binding.btn4Choice1.text = getString(R.string.p11_btn1)
                binding.btn4Choice2.text = getString(R.string.p11_btn2)
            }
            "12" -> {
                btnHide.visibility = View.GONE
                binding.imgView2.setImageResource(R.drawable.costume)
                binding.text4Edit.text = getString(R.string.p12_question)
                binding.btn4Choice1.text = getString(R.string.p9_btn1)
                //binding.btn6Choice2.text = getString(R.string.p9_btn2)
            }
            "13" -> {
                btnHide.visibility = View.GONE
                binding.imgView2.setImageResource(R.drawable.costume)
                binding.text4Edit.text = getString(R.string.p13_question)
                binding.btn4Choice1.text = getString(R.string.p10_btn1)
                //binding.btn6Choice2.text = getString(R.string.p8_btn2)
            }
        }

        binding.btn4Choice1.setOnClickListener {
            when (page) {
                "4", "5", "6", "8" -> {
                    val intent = Intent(this, ScenarioPlay::class.java)
                    intent.putExtra(PageName.page, "7")
                    startActivity(intent)
                    finish()
                }
                "7" -> {
                    val intent = Intent(this, ScenarioPlay::class.java)
                    intent.putExtra(PageName.page, "9")
                    startActivity(intent)
                    finish()
                }
                "9", "10", "12", "13", -> {
                    val intent = Intent(this, EndGame::class.java)
                    startActivity(intent)
                    finish()
                }
                "11" -> {
                    val intent = Intent(this, ScenarioPlay::class.java)
                    intent.putExtra(PageName.page, "12")
                    startActivity(intent)
                    finish()
                }
            }
        }

        binding.btn4Choice2.setOnClickListener {
            val intent = Intent(this, ScenarioPlay::class.java)
            when (page) {
                "4","5","6" -> {intent.putExtra(PageName.page, "8")}
                "7" -> {intent.putExtra(PageName.page, "10")}
                "8" -> {intent.putExtra(PageName.page, "11")}
                "11" -> {intent.putExtra(PageName.page, "13")}
            }
            startActivity(intent)
            finish()
        }
    }
}
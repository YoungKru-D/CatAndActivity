package com.tsu.catandactivityvisualnovel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tsu.catandactivityvisualnovel.databinding.ActivityScenarioPlayBinding

class ScenarioPlay : AppCompatActivity() {
    lateinit var binding: ActivityScenarioPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScenarioPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val page = intent.getStringExtra(PageName.page).toString()
        val btnHide = findViewById<Button>(R.id.btn4Choice2)

        val pageData = getPageData(page)
        binding.imgView2.setImageResource(pageData.imageResId)
        binding.text4Edit.text = getString(pageData.questionResId)
        binding.btn4Choice1.text = getString(pageData.button1ResId)
        binding.btn4Choice2.text = getString(pageData.button2ResId)

        if (page == "9" || page == "10" || page == "12" || page == "13") {
            btnHide.visibility = View.GONE
        }

        binding.btn4Choice1.setOnClickListener {
            val nextPage = getNextPage(page, true)
            val intent = if (nextPage == "EndGame") {
                Intent(this, EndGame::class.java)
            } else {
                Intent(this, ScenarioPlay::class.java)
            }
            intent.putExtra(PageName.page, nextPage)
            startActivity(intent)
            finish()
        }

        binding.btn4Choice2.setOnClickListener {
            val nextPage = getNextPage(page, false)
            val intent = Intent(this, ScenarioPlay::class.java)
            intent.putExtra(PageName.page, nextPage)
            startActivity(intent)
            finish()
        }
    }

    private fun getPageData(page: String): PageData {
        return when (page) {
            "4" -> PageData(R.drawable.walking, R.string.p4_question, R.string.p4_btn1, R.string.p4_btn2)
            "5" -> PageData(R.drawable.hiking, R.string.p5_question, R.string.p5_btn1, R.string.p5_btn2)
            "6" -> PageData(R.drawable.field, R.string.p6_question, R.string.p6_btn1, R.string.p6_btn2)
            "7" -> PageData(R.drawable.watching, R.string.p7_question, R.string.p7_btn1, R.string.p7_btn2)
            "8" -> PageData(R.drawable.helloween, R.string.p8_question, R.string.p8_btn1, R.string.p8_btn2)
            "9" -> PageData(R.drawable.watching, R.string.p9_question, R.string.p9_btn1, R.string.blank)
            "10" -> PageData(R.drawable.watching, R.string.p10_question, R.string.p10_btn1, R.string.p8_btn2)
            "11" -> PageData(R.drawable.costume, R.string.p11_question, R.string.p11_btn1, R.string.p11_btn2)
            "12" -> PageData(R.drawable.costume, R.string.p12_question, R.string.p9_btn1, R.string.blank)
            "13" -> PageData(R.drawable.costume, R.string.p13_question, R.string.p10_btn1, R.string.p8_btn2)
            else -> PageData(R.drawable.bg1, R.string.blank, R.string.blank, R.string.blank)
        }
    }

    private fun getNextPage(currentPage: String, isButton1Clicked: Boolean): String {
        return when (currentPage) {
            "4", "5", "6", "8" -> if (isButton1Clicked) "7" else "8"
            "7" -> if (isButton1Clicked) "9" else "10"
            "9", "10", "12", "13" -> "EndGame"
            "11" -> if (isButton1Clicked) "12" else "13"
            else -> ""
        }
    }

    data class PageData(val imageResId: Int, val questionResId: Int, val button1ResId: Int, val button2ResId: Int)
}
//getPageData(): This method returns a PageData object that contains image, question, and button text information based on the received page number as a parameter.
//
//getNextPage(): This method returns the next page number based on the current page and which button the user clicked.
package com.tsu.catandactivityvisualnovel

import android.view.View
import android.widget.Button
import androidx.test.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test

@Suppress("DEPRECATION")
class ButtonTest {
    @Test
    fun verifyID_HideButton_IdMatchesExpected() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val btnHide = Button(context)
        btnHide.id = R.id.btn4Choice2

        Assert.assertEquals(R.id.btn4Choice2, btnHide.id)
    }

    @Test
    fun verifyVisibility_HideButton_VisibleByDefault() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val btnHide = Button(context)

        Assert.assertEquals(View.VISIBLE, btnHide.visibility)
    }

    @Test
    fun verifyText_HideButton_TextMatchesExpected() {
        val context = InstrumentationRegistry.getInstrumentation().context
        val btnHide = Button(context)
        btnHide.text = "Hide"

        Assert.assertEquals("Hide", btnHide.text)
    }
}
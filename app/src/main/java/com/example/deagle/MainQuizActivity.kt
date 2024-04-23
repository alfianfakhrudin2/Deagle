package com.example.deagle

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz)

        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        val rgOptions = findViewById<RadioGroup>(R.id.rg_options)
        val btnPrevious = findViewById<Button>(R.id.btn_previous)
        val btnNext = findViewById<Button>(R.id.btn_next)

        // Set the question text
        tvQuestion.text = "Apa yang dimaksud dengan \"UI\" dalam desain UI/UX?"

        // Setup options (normally you would fetch these from a data source)
        val options = listOf(
            "User Interface",
            "User Experience",
            "User Management",
            "User Analysis"
        )

        options.forEachIndexed { index, option ->
            (rgOptions.getChildAt(index) as RadioButton).text = option
        }

        // Button click listeners
        btnPrevious.setOnClickListener {
            // TODO: Implement what should happen when the Previous button is clicked
        }

        btnNext.setOnClickListener {
            // TODO: Implement what should happen when the Next button is clicked
        }
    }
}
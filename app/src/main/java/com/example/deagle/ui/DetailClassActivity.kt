package com.example.deagle.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailClassBinding

class DetailClassActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageViewBack.setOnClickListener {
            onBackPressed()
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        // Kembali ke fragment profile dengan menutup aktivitas SertifikatActivity
        finish()
    }
}
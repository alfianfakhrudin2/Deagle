package com.example.deagle

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.databinding.ActivityUnduhSertifBinding
import com.example.deagle.ui.SertifikatActivity

class UnduhSertifActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnduhSertifBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUnduhSertifBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        // Sembunyikan ActionBar
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
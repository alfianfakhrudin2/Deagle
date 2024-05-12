package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailHasilBinding

class DetailHasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHasilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailHasilBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imageViewBack.setOnClickListener {
            onBackPressed()
        }

        binding.crLaporSoal.setOnClickListener {
            // Pindah ke aktivitas LaporSoalActivity
            startActivity(Intent(this, LaporSoalActivity::class.java))
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        // Kembali ke fragment profile dengan menutup aktivitas SertifikatActivity
        finish()
    }

}
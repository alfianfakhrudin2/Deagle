package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailKelasSayaBinding

class DetailKelasSayaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailKelasSayaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailKelasSayaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.clUlasanMentor.setOnClickListener{
            val intent = Intent(this, UlasanMentorActivity::class.java)
            startActivity(intent)
        }

        binding.ivBack.setOnClickListener{
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
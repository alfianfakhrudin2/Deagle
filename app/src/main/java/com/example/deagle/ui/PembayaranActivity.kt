package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityPembayaranBinding

class PembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembayaranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLanjutPembayaran.setOnClickListener {
            val intent = Intent(this, BayarActivity::class.java)
            startActivity(intent)
        }

        binding.btnPilih.setOnClickListener() {
            if (binding.paymentOptionRg.visibility == View.VISIBLE) {
                binding.paymentOptionRg.visibility = View.INVISIBLE
            } else {
                binding.paymentOptionRg.visibility = View.VISIBLE
            }
        }

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
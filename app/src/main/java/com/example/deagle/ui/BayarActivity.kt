package com.example.deagle.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityBayarBinding
import com.example.deagle.databinding.ActivityPembayaranBinding

class BayarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBayarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBayarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.ivCopy.setOnClickListener {
            // Menampilkan pesan toast
            Toast.makeText(this, "Teks berhasil disalin!", Toast.LENGTH_SHORT).show()
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
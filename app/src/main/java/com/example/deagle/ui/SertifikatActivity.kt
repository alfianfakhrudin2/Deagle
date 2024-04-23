package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.databinding.ActivitySertifikatBinding
import com.example.deagle.UnduhSertifActivity

class SertifikatActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySertifikatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySertifikatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur edge-to-edge display
        enableEdgeToEdge()

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // Memberi aksi pada tombol "btnLihatSertifikat"
        binding.btnLihatSertifikat.setOnClickListener {
            // Membuat Intent untuk berpindah ke UnduhSertifActivity
            val intent = Intent(this, UnduhSertifActivity::class.java)

            // Memulai aktivitas UnduhSertifActivity
            startActivity(intent)
        }

        // Memberikan aksi pada tombol "ivBack" untuk kembali ke fragment profile
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    // Mengatur aksi saat tombol back ditekan
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        // Kembali ke fragment profile dengan menutup aktivitas SertifikatActivity
        finish()
    }
}


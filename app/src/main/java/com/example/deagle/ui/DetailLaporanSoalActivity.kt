package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailLaporanSoalBinding

class DetailLaporanSoalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailLaporanSoalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailLaporanSoalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.clRiwayatLaporan.setOnClickListener {
            val Intent = Intent(this, RiwayatActivity::class.java)
            startActivity(Intent)
        }

        binding.constraintLayout4.setOnClickListener {
            val Intent = Intent(this, DetailHasilPengerjaanActivity::class.java)
            startActivity(Intent)
        }


    }
}
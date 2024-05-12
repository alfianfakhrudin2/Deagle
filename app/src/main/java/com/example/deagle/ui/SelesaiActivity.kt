package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivitySelesaiBinding
import com.example.deagle.ui.kelas.detail.ClassDetailActivity
import com.example.deagle.ui.kelas.detail.ClassDetailFragment

class SelesaiActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelesaiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelesaiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.appCompatButton2.setOnClickListener() {
            val intent = Intent(this, DetailHasilActivity::class.java)
            startActivity(intent)
        }

        binding.btnKeluar.setOnClickListener() {
            val intent = Intent(this, ClassDetailActivity::class.java)
            startActivity(intent)
        }

    }
}
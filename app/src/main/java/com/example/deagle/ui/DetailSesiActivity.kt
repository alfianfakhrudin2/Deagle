package com.example.deagle.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailSesiBinding

class DetailSesiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSesiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailSesiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.ivBack.setOnClickListener() {
            onBackPressed()
        }

    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
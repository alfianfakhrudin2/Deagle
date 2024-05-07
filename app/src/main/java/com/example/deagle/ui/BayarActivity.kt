package com.example.deagle.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R

class BayarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bayar)
        val ivCopy = findViewById<ImageView>(R.id.iv_copy)
        ivCopy.setOnClickListener {
            // Menampilkan pesan toast
            Toast.makeText(this, "Teks berhasil disalin!", Toast.LENGTH_SHORT).show()
        }

    }
}
package com.example.deagle.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityPembayaranBinding

class PembayaranActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPembayaranBinding
    private var isOptionsVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLanjutPembayaran.setOnClickListener {
            // Handle button click
            val intent = Intent(this, BayarActivity::class.java)
            startActivity(intent)
        }

        binding.btnPilih.setOnClickListener {
            // Toggle flag
            isOptionsVisible = !isOptionsVisible
            // Update visibility
            setPaymentVisibility(isOptionsVisible)
            // Update icon
            setArrowIcon()
        }

        binding.imageViewBack.setOnClickListener {
            onBackPressed()
        }

        // Set initial visibility and icon for csPayment
        setPaymentVisibility(isOptionsVisible)
        // Set initial icon for btnPilih
        setArrowIcon()
    }

    // Function to set visibility of csPayment based on isOptionsVisible
    private fun setPaymentVisibility(isVisible: Boolean) {
        binding.csPayment.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    // Function to set arrow icon based on visibility
    private fun setArrowIcon() {
        val arrowDrawable: Drawable? = if (isOptionsVisible) {
            ContextCompat.getDrawable(this, R.drawable.ic_arrow_up)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_arrow_down)
        }
        // Set arrow icon to the end of the button
        binding.btnPilih.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowDrawable, null)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

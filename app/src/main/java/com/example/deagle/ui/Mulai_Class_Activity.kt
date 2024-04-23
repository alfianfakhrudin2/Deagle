package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.MainActivity
import com.example.deagle.R
import com.example.deagle.databinding.ActivityLoginBinding
import com.example.deagle.databinding.ActivityMulaiClassBinding

class Mulai_Class_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMulaiClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMulaiClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnMulaiKelas.setOnClickListener{
            // Menampilkan alert dialog
            showSuccessAlertDialog()
        }

    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.custom_dialog_login, null)

        builder.setView(view)

        val alertDialog: AlertDialog = builder.create()

        alertDialog.setCanceledOnTouchOutside(false)

        val btnLanjutkanMulai = view.findViewById<Button>(R.id.btnLanjutkanLogin1)

        btnLanjutkanMulai.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        alertDialog.show()
    }
}
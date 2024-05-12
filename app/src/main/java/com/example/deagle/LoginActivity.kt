package com.example.deagle

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.databinding.ActivityLoginBinding
import com.example.deagle.databinding.ActivityStartBinding
import com.example.deagle.ui.RegisterActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            // Menampilkan alert dialog
            showSuccessAlertDialog()
        }
        supportActionBar?.hide()
    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.custom_dialog_login, null)

        // Menentukan lebar dan tinggi dialog
        val width = resources.displayMetrics.widthPixels * 0.3 // Misalnya, 80% dari lebar layar
        val height = WindowManager.LayoutParams.WRAP_CONTENT // Tinggi sesuai dengan konten

        builder.setView(view)

        val alertDialog = builder.create()

        // Mengatur lebar dan tinggi dialog
            alertDialog.window?.setLayout(width.toInt(), height)

            alertDialog.setCanceledOnTouchOutside(false)

        val btnLanjutkanLogin = view.findViewById<Button>(R.id.btnLanjutkanLogin1)

        btnLanjutkanLogin.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        alertDialog.show()
    }

}

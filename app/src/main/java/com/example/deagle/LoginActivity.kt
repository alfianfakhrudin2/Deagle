package com.example.deagle

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
import com.example.deagle.databinding.ActivityLoginBinding
import com.example.deagle.databinding.ActivityStartBinding
import com.example.deagle.ui.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            // Menampilkan alert dialog
            showSuccessAlertDialog()
        }

        binding.txtSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        supportActionBar?.hide()
    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.custom_dialog_login, null)

        builder.setView(view)

        val alertDialog: AlertDialog = builder.create()

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
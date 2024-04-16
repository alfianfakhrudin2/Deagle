package com.example.deagle.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deagle.R
import com.example.deagle.databinding.ActivityStartBinding
import com.example.deagle.databinding.ActivityVerifikasiBinding

class VerifikasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerifikasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVerifikasiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        // Tombol "Kirim" diklik
        binding.btnKirim.setOnClickListener {
            // Menampilkan alert dialog
            showSuccessAlertDialog()
        }
        supportActionBar?.hide()
    }
    // Method untuk menampilkan AlertDialog berhasil
    private fun showSuccessAlertDialog() {
        // Membuat AlertDialog.Builder
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.custome_dialog, null)

        // Menentukan view untuk AlertDialog
        builder.setView(view)

        // Membuat AlertDialog
        val alertDialog: AlertDialog = builder.create()

        // Mengatur agar AlertDialog tidak dapat dibatalkan dengan klik di luar dialog
        alertDialog.setCanceledOnTouchOutside(false)

        // Mendapatkan button "Lanjutkan" dari layout AlertDialog
        val btnLanjutkan = view.findViewById<Button>(R.id.btnLanjutkan)

        // Mengatur onClickListener untuk button "Lanjutkan"
        btnLanjutkan.setOnClickListener {
            // Menutup AlertDialog
            alertDialog.dismiss()
            // Tambahkan kode lanjutan di sini jika diperlukan
        }

        // Menampilkan AlertDialog
        alertDialog.show()
    }
}
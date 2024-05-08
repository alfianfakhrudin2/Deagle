package com.example.deagle.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.R

class LaporSoalActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var btnKirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lapor_soal)
        supportActionBar?.hide()

        val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage)
        btnKirim = findViewById(R.id.btnKirim)
        btnKirim.isEnabled = false // Menonaktifkan tombol btnKirim saat pertama kali
        btnKirim.alpha = 0.5f // Mengatur transparansi tombol ketika dinonaktifkan

        btnSelectImage.setOnClickListener {
            openFileChooser()
        }
    }

    private fun openFileChooser() {
        val intent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val uri = data.data
            val fileName = uri?.let { getFileName(it) }
            if (fileName != null) {
                val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage)
                btnSelectImage.text = fileName
                Toast.makeText(this, "Nama file: $fileName", Toast.LENGTH_SHORT).show()

                // Mengaktifkan tombol Kirim karena pengguna telah memilih file gambar
                btnKirim.isEnabled = true
                btnKirim.alpha = 1.0f // Mengembalikan transparansi tombol ke nilai awal
            } else {
                Toast.makeText(this, "Nama file tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getFileName(uri: Uri): String? {
        var result: String? = null
        contentResolver.query(uri, null, null, null, null)?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                result = it.getString(nameIndex)
            }
        }
        return result
    }
}

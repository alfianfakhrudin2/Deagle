package com.example.deagle.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.R

class UlasanMentorActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulasan_mentor)
        supportActionBar?.hide()
        val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage)
        btnSelectImage.setOnClickListener {
            openFileChooser()
        }
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
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
            } else {
                Toast.makeText(this, "Nama file tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getFileName(uri: Uri): String? {
        var result: String? = null
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                result = it.getString(nameIndex)
            }
        }
        return result
    }
}



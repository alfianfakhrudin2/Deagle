package com.example.deagle.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.R

class UlasanMentorActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var btnKirim: Button
    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulasan_mentor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back button in action bar
        val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage)
        btnback = findViewById(R.id.ivBack_ulasan)
        btnKirim = findViewById(R.id.btnKirim)
        btnKirim.isEnabled = false
        btnKirim.alpha = 0.5f
        btnback.setOnClickListener {
            onBackPressed()
        }

        btnSelectImage.setOnClickListener {
            openFileChooser()
        }
        btnKirim.setOnClickListener {
            showSuccessAlertDialog()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar back button click here
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.ulasan_mentor_dialog, null)

        val width = resources.displayMetrics.widthPixels * 0.3
        val height = WindowManager.LayoutParams.WRAP_CONTENT

        builder.setView(view)

        val alertDialog = builder.create()

        alertDialog.window?.setLayout(width.toInt(), height)

        alertDialog.setCanceledOnTouchOutside(false)

        val btnLanjutkanLogin = view.findViewById<Button>(R.id.yes_button_ulasan_mentor)
        val btnNoUlasanMentor = view.findViewById<Button>(R.id.no_button_ulasan_mentor)

        btnNoUlasanMentor.setOnClickListener {
            alertDialog.dismiss()
        }

        btnLanjutkanLogin.setOnClickListener {
            alertDialog.dismiss()
            showSecondDialog()
        }

        alertDialog.show()
    }

    private fun showSecondDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.sukses_ulasan_mentor_dialog, null)

        builder.setView(view)

        val alertDialog = builder.create()

        alertDialog.setCanceledOnTouchOutside(false)

        val btnRiwayatLaporanSoal = view.findViewById<Button>(R.id.kembali_button)

        btnRiwayatLaporanSoal.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, DetailKelasSayaActivity::class.java)
            startActivity(intent)
        }

        alertDialog.show()
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

                btnKirim.isEnabled = true
                btnKirim.alpha = 1.0f
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

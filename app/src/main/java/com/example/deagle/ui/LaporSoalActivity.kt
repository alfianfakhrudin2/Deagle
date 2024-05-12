package com.example.deagle.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.MainActivity
import com.example.deagle.R

class LaporSoalActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var btnKirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lapor_soal)
        supportActionBar?.hide()

        val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage_soal)
        btnKirim = findViewById(R.id.btnKirimLapor)
        btnKirim.isEnabled = false
        btnKirim.alpha = 0.5f

        btnSelectImage.setOnClickListener {
            openFileChooser()
        }
        btnKirim.setOnClickListener {
            showSuccessAlertDialog()
        }

    }

    private fun showSuccessAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.custome_lapor_soal_dialog, null)

        val width = resources.displayMetrics.widthPixels * 0.3
        val height = WindowManager.LayoutParams.WRAP_CONTENT

        builder.setView(view)

        val alertDialog = builder.create()

        alertDialog.window?.setLayout(width.toInt(), height)

        alertDialog.setCanceledOnTouchOutside(false)

        val btnLanjutkanLogin = view.findViewById<Button>(R.id.btnYa)

        btnLanjutkanLogin.setOnClickListener {
            alertDialog.dismiss()
            showSecondDialog() // Navigasi ke dialog kedua
        }

        alertDialog.show()
    }

    private fun showSecondDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.confirmation_sukses_lapor_soal, null)

        // Atur tampilan dan lainnya sesuai kebutuhan
        builder.setView(view)

        val alertDialog = builder.create()

        // Atur ukuran dialog dan lainnya sesuai kebutuhan
        alertDialog.setCanceledOnTouchOutside(false)

        val btnRiwayatLaporanSoal = view.findViewById<Button>(R.id.btnRiwayat)

        btnRiwayatLaporanSoal.setOnClickListener {
            alertDialog.dismiss()
            // Navigasi ke DetailLaporanSoalActivity saat btnRiwayat diklik
            val intent = Intent(this, DetailLaporanSoalActivity::class.java)
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
                val btnSelectImage = findViewById<TextView>(R.id.btnSelectImage_soal)
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

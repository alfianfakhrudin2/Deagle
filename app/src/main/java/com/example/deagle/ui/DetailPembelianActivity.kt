package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailPembelianBinding
import com.example.deagle.ui.adapter.LanguageAdapter
import java.util.Locale

class DetailPembelianActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter
    private lateinit var binding: ActivityDetailPembelianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPembelianBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        supportActionBar?.hide()
        recyclerView = binding.rvDetailclass

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        binding.btnBeli.setOnClickListener {
            val intent = Intent(this, PembayaranActivity::class.java)
            startActivity(intent)
        }

        binding.ivBack.setOnClickListener() {
            onBackPressed()
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun addDataToList() {
        mList.add(
            LanguageData(
                "Materi Pembelajaran",
                R.drawable.poto1,
                "Kelas ini dirancang untuk membawa Anda melintasi dunia desain UI/UX yang menarik dan dinamis. Dengan fokus pada pengalaman pengguna yang memikat, Anda akan dibimbing melalui berbagai konsep dan praktik terkini dalam merancang antarmuka yang intuitif dan menarik."
            )
        )
        mList.add(
            LanguageData(
                "Uji Kompetensi",
                R.drawable.poto1,
                "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise."
            )
        )
        mList.add(
            LanguageData(
                "Sertifikat",
                R.drawable.img1,
                "The HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser."
            )
        )
    }
}

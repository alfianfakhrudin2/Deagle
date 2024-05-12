package com.example.deagle.ui.kelas.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.deagle.R
import com.example.deagle.data.DeagleClassMaterial
import com.example.deagle.databinding.ActivityBayarBinding
import com.example.deagle.databinding.ActivityClassDetailBinding

class ClassDetailActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityClassDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityClassDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.class_detail_frame_container)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // Calling Class Material Fragment
//        val fragmentManager = supportFragmentManager
//        val classDetailFragment = ClassDetailFragment()
//        val fragment = fragmentManager.findFragmentByTag(ClassDetailFragment::class.java.simpleName)
//        if (fragment !is ClassDetailFragment) {
//            fragmentManager.beginTransaction()
//                .add(R.id.class_detail_frame_container, classDetailFragment, ClassDetailFragment::class.java.simpleName)
//                .commit()
//        }


        val fragmentManager = supportFragmentManager
        val classDetailFragment = ClassDetailFragment()
        val fragment = fragmentManager.findFragmentByTag(ClassDetailFragment::class.java.simpleName)
        if (fragment !is ClassDetailFragment) {
            fragmentManager.beginTransaction()
                .add(R.id.class_detail_frame_container, classDetailFragment, ClassDetailFragment::class.java.simpleName)
                .commit()
        }


    }


}
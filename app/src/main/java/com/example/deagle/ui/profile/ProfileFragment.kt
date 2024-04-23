package com.example.deagle.ui.profile

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.deagle.LoginActivity
import com.example.deagle.R
import com.example.deagle.databinding.FragmentProfileBinding
import com.example.deagle.ui.SertifikatActivity
import com.example.deagle.ui.kelas.ClassViewModel

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Mengatur tindakan klik pada tombol arrow
        binding.arrow.setOnClickListener {
            val intent = Intent(activity, SertifikatActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Implementasi ketika tombol di klik
        view.findViewById<Button>(R.id.signupButton).setOnClickListener {
            // Membuat Intent untuk berpindah ke Activity
            val intent = Intent(activity, LoginActivity::class.java)

            // (Opsional) Mengirim data menggunakan Intent
            intent.putExtra("key", "value")

            // Memulai Activity baru
            startActivity(intent)
        }
    }
}

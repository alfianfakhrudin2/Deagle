package com.example.deagle.ui.kelas

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deagle.databinding.FragmentActiveBinding
import com.example.deagle.ui.DetailClassActivity

class ActiveFragment : Fragment() {
    private var _binding: FragmentActiveBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ActiveFragment()
    }

    private val viewModel: ActiveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentActiveBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.constraintLayoutDesignMastery.setOnClickListener {
            val intent = Intent(activity, DetailClassActivity::class.java)
            startActivity(intent)
        }
    }
}
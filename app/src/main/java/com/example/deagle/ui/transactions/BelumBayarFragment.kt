package com.example.deagle.ui.transactions

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deagle.R
import com.example.deagle.databinding.FragmentActiveBinding
import com.example.deagle.databinding.FragmentBelumBayarBinding
import com.example.deagle.ui.BayarActivity
import com.example.deagle.ui.DetailClassActivity
import com.example.deagle.ui.PembayaranActivity

class BelumBayarFragment : Fragment() {
    private var _binding: FragmentBelumBayarBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = BelumBayarFragment()
    }

    private val viewModel: BelumBayarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBelumBayarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBayar.setOnClickListener {
            val intent = Intent(activity, PembayaranActivity::class.java)
            startActivity(intent)
        }
    }
}
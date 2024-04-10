package com.example.deagle.ui.transactions

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.deagle.databinding.FragmentTransactionsBinding

import com.example.deagle.ui.kelas.ClassViewModel

class TransactionsFragment : Fragment() {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = TransactionsFragment()
    }

    private val viewModel: TransactionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val TransactionsViewModel =
            ViewModelProvider(this).get(ClassViewModel::class.java)
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView5
        TransactionsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
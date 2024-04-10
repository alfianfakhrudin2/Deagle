package com.example.deagle.ui.transactions

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deagle.R

class BelumBayarFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_belum_bayar, container, false)
    }
}
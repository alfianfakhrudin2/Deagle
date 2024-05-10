package com.example.deagle.ui.kelas.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deagle.R
import com.example.deagle.data.Question
import com.example.deagle.databinding.FragmentDummyBinding


class DummyFragment : Fragment() {
    private var _binding: FragmentDummyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDummyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val bundle = arguments
            if (bundle != null) {
                val question = bundle.getParcelableArrayList<Question>(DCM_QUESTIONS_KEY)
                if (question != null) {
                    tv.text = question[0].answers[0].answer
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
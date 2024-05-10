package com.example.deagle.ui.kelas.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deagle.databinding.FragmentAnswerBinding
import com.example.deagle.ui.kelas.detail.viewmodel.AnswerViewModel

class AnswerFragment(
) : Fragment() {
    private var _binding: FragmentAnswerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnswerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[AnswerViewModel::class.java]
        binding.apply {
            viewModel.question.observe(viewLifecycleOwner) {
                questionText.text = it.question

                answerARb.text = it.answers[0].answer
                answerBRb.text = it.answers[1].answer
                answerCRb.text = it.answers[2].answer
                answerDRb.text = it.answers[3].answer


            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
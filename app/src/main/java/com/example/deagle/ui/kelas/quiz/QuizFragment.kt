package com.example.deagle.ui.kelas.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.deagle.R
import com.example.deagle.databinding.FragmentQuizBinding
import com.example.deagle.ui.kelas.detail.ConfirmationDialogFragment

const val DCM_QUESTION_KEY = "DCM_QUESTION_KEY"
const val DCM_ANSWERS_KEY = "DCM_ANSWERS_KEY"
const val DCM_ANSWER_KEY = "DCM_ANSWER_KEY"
const val DCM_IS_SELECTED_KEY = "DCM_IS_SELECTED_KEY"

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
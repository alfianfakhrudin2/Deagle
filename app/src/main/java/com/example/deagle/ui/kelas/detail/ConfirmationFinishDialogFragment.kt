package com.example.deagle.ui.kelas.detail

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.deagle.R
import com.example.deagle.databinding.ConfirmationFinishDialogBinding
import com.example.deagle.ui.SelesaiActivity
import com.example.deagle.ui.kelas.quiz.QuizFragment


class ConfirmationFinishDialogFragment : DialogFragment() {
    private var onDialogActionButtonListener: ConfirmationFinishDialogFragment.OnDialogActionButtonListener? = null
    private var _binding: ConfirmationFinishDialogBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parentFragment = parentFragment
        if (parentFragment is QuizFragment) {
            this.onDialogActionButtonListener = parentFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ConfirmationFinishDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            yesButton.setOnClickListener {
                val intent = Intent(requireContext(), SelesaiActivity::class.java)
                startActivity(intent)
                dismiss()
            }

            noButton.setOnClickListener {
                dialog?.cancel()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    interface OnDialogActionButtonListener {
        fun onActionChosen(choice: Boolean)
    }

}
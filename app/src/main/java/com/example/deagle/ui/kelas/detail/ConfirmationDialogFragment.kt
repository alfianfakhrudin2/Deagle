package com.example.deagle.ui.kelas.detail

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import com.example.deagle.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs

class ConfirmationDialogFragment : DialogFragment() {
    private var onDialogActionButtonListener: OnDialogActionButtonListener? = null
    private lateinit var yesButton: MaterialButton
    private lateinit var noButton: MaterialButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parentFragment = parentFragment
        if (parentFragment is ClassTaskFragment) {
            this.onDialogActionButtonListener = parentFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.confirmation_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yesButton = view.findViewById(R.id.yes_button)
        noButton = view.findViewById(R.id.no_button)

        yesButton.setOnClickListener {
            onDialogActionButtonListener?.onActionChosen(choice = true)
//            Toast.makeText(requireActivity(), "wjwjw", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }

        noButton.setOnClickListener {
            onDialogActionButtonListener?.onActionChosen(choice = false)
            dialog?.cancel()
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.onDialogActionButtonListener = null
    }

    interface OnDialogActionButtonListener {
        fun onActionChosen(choice: Boolean)
    }

}
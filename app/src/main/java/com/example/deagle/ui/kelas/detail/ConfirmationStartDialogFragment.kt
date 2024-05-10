package com.example.deagle.ui.kelas.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.deagle.R
import com.google.android.material.button.MaterialButton

class ConfirmationStartDialogFragment : DialogFragment() {
    private var onDialogActionButtonListener: OnDialogActionButtonListener? = null
    private lateinit var yesButton: MaterialButton
    private lateinit var noButton: MaterialButton
    private lateinit var confirmationDialogTitleText: TextView
    private lateinit var confirmationDialogDescText: TextView

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
        return inflater.inflate(R.layout.confirmation_start_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yesButton = view.findViewById(R.id.yes_button)
        noButton = view.findViewById(R.id.no_button)
        confirmationDialogTitleText = view.findViewById(R.id.confirmation_dialog_text)
        confirmationDialogDescText = view.findViewById(R.id.confirmation_dialog_desc_text)

        yesButton.setOnClickListener {
            onDialogActionButtonListener?.onActionChosen(choice = true)
            dialog?.dismiss()
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
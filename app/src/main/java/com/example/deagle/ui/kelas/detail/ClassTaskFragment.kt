package com.example.deagle.ui.kelas.detail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import com.example.deagle.R
import com.example.deagle.databinding.FragmentClassTaskBinding
import com.example.deagle.ui.kelas.quiz.QuizFragment

const val DCM_KEY = "DCM_KEY"
const val DCM_ID_KEY = "DCM_ID_KEY"
const val DCM_TITLE_KEY = "DCM_TITLE_KEY"
const val DCM_DESC_KEY = "DCM_DESC_KEY"
const val DCM_TYPE_KEY = "DCM_TYPE_KEY"
const val DCM_WORKING_TIME_KEY = "DCM_WORKING_TIME_KEY"
const val DCM_DEADLINE_KEY = "DCM_DEADLINE_KEY"
const val DCM_IS_FINISHED_KEY = "DCM_IS_FINISHED_KEY"
const val DCM_STATUS_ICON_KEY = "DCM_STATUS_ICON_KEY"
const val DCM_FINISHED_DATE_KEY = "DCM_FINISHED_DATE_KEY"
const val DCM_QUESTIONS_KEY = "DCM_QUESTIONS_KEY"

class ClassTaskFragment : Fragment(), ConfirmationStartDialogFragment.OnDialogActionButtonListener {

    private var _binding: FragmentClassTaskBinding? = null
    private val binding get() =  _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClassTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {


            topAppBar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }

            if (arguments != null) {
                classMaterialTitleText.text = arguments?.getString(DCM_TITLE_KEY)
                classMaterialStatusIcon.setImageResource(requireArguments().getInt(DCM_STATUS_ICON_KEY))
                classMaterialDeadlineText.text = arguments?.getString(DCM_DEADLINE_KEY)
                classMaterialStatusFinishedText.text = if (arguments?.getBoolean(DCM_IS_FINISHED_KEY) == true) {
                    classMaterialStatusText.visibility = View.GONE
                    classMaterialStatusIcon.visibility = View.GONE
                    classMaterialDeadlineText.visibility = View.GONE
                    classMaterialStatusFinishedText.visibility = View.VISIBLE
                    classMaterialDeadlineFinishedText.visibility = View.VISIBLE
                    "Selesai"
                } else {
                    ""
                }
                classMaterialDeadlineFinishedText.text = if (arguments?.getBoolean(DCM_IS_FINISHED_KEY) == true && arguments?.getString(
                        DCM_FINISHED_DATE_KEY) != null) {
                    classMaterialStatusText.visibility = View.GONE
                    classMaterialStatusIcon.visibility = View.GONE
                    classMaterialDeadlineText.visibility = View.GONE
                    classMaterialStatusFinishedText.visibility = View.VISIBLE
                    classMaterialDeadlineFinishedText.visibility = View.VISIBLE
                    arguments?.getString(DCM_FINISHED_DATE_KEY)
                } else {
                    ""
                }
                descriptionText.text = arguments?.getString(DCM_DESC_KEY)
                taskTypeText.text = arguments?.getString(DCM_TYPE_KEY)
                workingTimeText.text = arguments?.getString(DCM_WORKING_TIME_KEY)
            }

            startTaskButton.setOnClickListener {
                //Trigger Confirmation
                val confirmationDialogFragment = ConfirmationStartDialogFragment()
                val fragmentManager = childFragmentManager

                confirmationDialogFragment.show(fragmentManager, ConfirmationStartDialogFragment::class.java.simpleName)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onActionChosen(choice: Boolean) {
        if (choice) {
            val bundle = Bundle()
            bundle.putString(DCM_TITLE_KEY, arguments?.getString(DCM_TITLE_KEY))
            bundle.putParcelableArrayList(DCM_QUESTIONS_KEY, arguments?.getParcelableArrayList(
                DCM_QUESTIONS_KEY))
            val quizFragment = QuizFragment()
            val fragmentManager = parentFragmentManager
            quizFragment.arguments = bundle
//            dummyFragment.arguments = bundle

            fragmentManager.beginTransaction()
                .replace(R.id.class_detail_frame_container, quizFragment, QuizFragment::class.java.simpleName)
//                .replace(R.id.class_detail_frame_container, dummyFragment, DummyFragment::class.java.simpleName)
                .addToBackStack(null)
                .addToBackStack(ConfirmationStartDialogFragment::class.java.simpleName)
                .commit()
        }
    }
}
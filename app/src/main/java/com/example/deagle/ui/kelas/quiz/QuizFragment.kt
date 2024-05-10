package com.example.deagle.ui.kelas.quiz

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2.*
import com.example.deagle.data.Question
import com.example.deagle.databinding.FragmentQuizBinding
import com.example.deagle.ui.kelas.detail.ConfirmationFinishDialogFragment
import com.example.deagle.ui.kelas.detail.ConfirmationStartDialogFragment
import com.example.deagle.ui.kelas.detail.DCM_QUESTIONS_KEY
import com.example.deagle.ui.kelas.detail.DCM_TITLE_KEY
import com.example.deagle.ui.kelas.detail.viewmodel.AnswerViewModel
import com.example.deagle.ui.kelas.quiz.adapter.AnswerPagerAdapter

const val DCM_QUESTION_KEY = "DCM_QUESTION_KEY"
const val DCM_ANSWERS_KEY = "DCM_ANSWERS_KEY"
const val DCM_ANSWER_KEY = "DCM_ANSWER_KEY"
const val DCM_IS_SELECTED_KEY = "DCM_IS_SELECTED_KEY"

class QuizFragment : Fragment(), ConfirmationFinishDialogFragment.OnDialogActionButtonListener {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private lateinit var answerPagerAdapter: AnswerPagerAdapter

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
        val bundle = arguments
        if (bundle != null) {
            val questions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelableArrayList(DCM_QUESTIONS_KEY, Question::class.java)
            } else {
                bundle.getParcelableArrayList(DCM_QUESTIONS_KEY)
            }

            binding.apply {

                topAppBar.setNavigationOnClickListener {
                    requireActivity().onBackPressed()
                }

                answerPagerAdapter = AnswerPagerAdapter(requireActivity())
                answerViewPager.adapter = answerPagerAdapter
                answerViewPager.isUserInputEnabled = false
                val viewModel = ViewModelProvider(requireActivity())[AnswerViewModel::class.java]

                if (questions != null) {
                    // First question will be showed first when answer fragment called
                    viewModel.addQuestion(questions[0])
                    topAppBar.subtitle = bundle.getString(DCM_TITLE_KEY)
                }

                rbOption1.setOnClickListener {
                    answerViewPager.setCurrentItem(0, true)
                }

                rbOption2.setOnClickListener {
                    answerViewPager.setCurrentItem(1, true)
                }

                rbOption3.setOnClickListener {
                    answerViewPager.setCurrentItem(2, true)
                }

                rbOption4.setOnClickListener {
                    answerViewPager.setCurrentItem(3, true)
                }

                rbOption5.setOnClickListener {
                    answerViewPager.setCurrentItem(4, true)
                }

//                if (answerViewPager.currentItem == answerViewPager.adapter?.itemCount?.minus(1)) {
//                    nextQuestionButton.setOnClickListener {
//                        launchDialog()
//                    }
//                }


                val callback = object : OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        when(position) {
                            0 -> {
                                rbOption1.isChecked = true
                                if (questions != null) {
                                    viewModel.addQuestion(question = questions[0])
                                }
                            }
                            1 -> {
                                rbOption2.isChecked = true
                                if (questions != null) {
                                    viewModel.addQuestion(question = questions[1])
                                }
                            }
                            2 -> {
                                rbOption3.isChecked = true
                                if (questions != null) {
                                    viewModel.addQuestion(question = questions[2])
                                }
                            }
                            3 -> {
                                rbOption4.isChecked = true
                                if (questions != null) {
                                    viewModel.addQuestion(question = questions[3])
                                }
                            }
                            4 -> {
                                rbOption5.isChecked = true
                                if (questions != null) {
                                    viewModel.addQuestion(question = questions[4])
                                }
                            }
                        }

                    }
                }


                previousQuestionButton.setOnClickListener {
                    answerViewPager.setCurrentItem(answerViewPager.currentItem, true)
                    answerViewPager.currentItem--
                    callback.onPageSelected(answerViewPager.currentItem)

                }

                nextQuestionButton.setOnClickListener {
                    answerViewPager.setCurrentItem(answerViewPager.currentItem, true)
                    answerViewPager.currentItem++
                    if (answerViewPager.currentItem == answerViewPager.adapter?.itemCount?.minus(1)) {
                        nextQuestionButton.setOnClickListener {
                            launchDialog()
                        }
                    }
                    callback.onPageSelected(answerViewPager.currentItem)
                }
            }
        }

    }

    private fun launchDialog() {
        val confirmationFinishDialogFragment = ConfirmationFinishDialogFragment()
        val fragmentManager = childFragmentManager
        confirmationFinishDialogFragment.show(fragmentManager, ConfirmationFinishDialogFragment::class.java.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onActionChosen(choice: Boolean) {
        TODO("Not yet implemented")
    }
}
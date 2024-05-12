package com.example.deagle.ui.kelas.quiz.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.data.Question
import com.example.deagle.ui.kelas.quiz.AnswerFragment

class AnswerPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AnswerFragment()
            1 -> AnswerFragment()
            2 -> AnswerFragment()
            3 -> AnswerFragment()
            4 -> AnswerFragment()
            else -> AnswerFragment()
        }
    }
}
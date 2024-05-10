package com.example.deagle.ui.kelas.detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.ui.kelas.detail.ClassMaterialFragment
import com.example.deagle.ui.kelas.quiz.QuizFragment

class ClassMaterialPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ClassMaterialFragment()
            1 -> ClassMaterialFragment()
            2 -> ClassMaterialFragment()
            else -> ClassMaterialFragment()
        }
    }
}
package com.example.deagle.ui.kelas.detail.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.ui.kelas.detail.ARG_OBJECT
import com.example.deagle.ui.kelas.detail.ClassMaterialFragment
import com.example.deagle.ui.kelas.detail.ClassTaskFragment
import com.example.deagle.ui.kelas.quiz.QuizFragment

class ClassMaterialAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
//        val fragment = ClassMaterialFragment()
//        fragment.arguments = Bundle().apply {
//            putInt(ARG_OBJECT, position + 1)
//        }

        return when(position) {
            0 -> ClassMaterialFragment()
            1 -> QuizFragment()
            2 -> ClassTaskFragment()
            else -> QuizFragment()
        }
//        return fragment
    }

}
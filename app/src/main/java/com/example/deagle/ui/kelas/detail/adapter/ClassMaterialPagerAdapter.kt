package com.example.deagle.ui.kelas.detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.ui.kelas.detail.ClassMaterialFragment
<<<<<<< HEAD
import com.example.deagle.ui.kelas.jadwal.JadwalFragment
import com.example.deagle.ui.kelas.materi.MateriFragment
=======
>>>>>>> 9d92de3fa4536a80163abff7a1d8636ca4199695
import com.example.deagle.ui.kelas.quiz.QuizFragment

class ClassMaterialPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
<<<<<<< HEAD
            0 -> JadwalFragment()
            1 -> MateriFragment()
=======
            0 -> ClassMaterialFragment()
            1 -> ClassMaterialFragment()
>>>>>>> 9d92de3fa4536a80163abff7a1d8636ca4199695
            2 -> ClassMaterialFragment()
            else -> ClassMaterialFragment()
        }
    }
}
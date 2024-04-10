package com.example.deagle.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deagle.ui.kelas.ActiveFragment
import com.example.deagle.ui.kelas.ClassFragment
import com.example.deagle.ui.kelas.HistoryFragment

class SectionsPagerAdapter(activity: ClassFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ActiveFragment()
            1 -> fragment = HistoryFragment()
        }
        return fragment as Fragment
    }

}
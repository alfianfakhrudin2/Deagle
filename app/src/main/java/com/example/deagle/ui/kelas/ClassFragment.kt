package com.example.deagle.ui.kelas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.deagle.R
import com.example.deagle.ui.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ClassFragment : Fragment() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.email,
            R.string.cPassword
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_class, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        val pagerAdapter = SectionsPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = getString(TAB_TITLES[position])
        }.attach()

        return view
    }
}


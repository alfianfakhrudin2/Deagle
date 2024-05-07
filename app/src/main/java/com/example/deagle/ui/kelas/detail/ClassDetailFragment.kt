package com.example.deagle.ui.kelas.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.deagle.databinding.FragmentClassDetailBinding
import com.example.deagle.ui.kelas.detail.adapter.ClassMaterialAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ClassDetailFragment : Fragment() {
    private var _binding: FragmentClassDetailBinding? = null
    private val binding = _binding!!
    private lateinit var classMaterialAdapter: ClassMaterialAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClassDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            classMaterialAdapter = ClassMaterialAdapter(requireParentFragment())
            binding.classMaterialViewPager.adapter = classMaterialAdapter
            classDetailTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    classMaterialViewPager.currentItem = tab.position
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {
                    TODO("Not yet implemented")
                }

                override fun onTabReselected(p0: TabLayout.Tab?) {
                    TODO("Not yet implemented")
                }

            })

            classMaterialViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.classDetailTab.getTabAt(position)?.select()
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
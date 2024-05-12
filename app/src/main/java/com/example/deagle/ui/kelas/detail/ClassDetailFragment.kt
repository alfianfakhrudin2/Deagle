package com.example.deagle.ui.kelas.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.deagle.R
import com.example.deagle.databinding.FragmentClassDetailBinding
import com.example.deagle.ui.DetailKelasSayaActivity
import com.example.deagle.ui.PembayaranActivity
import com.example.deagle.ui.UlasanMentorActivity
import com.example.deagle.ui.kelas.detail.adapter.ClassMaterialPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ClassDetailFragment : Fragment() {
    private var _binding: FragmentClassDetailBinding? = null
    private val binding get() =  _binding!!
    private lateinit var classMaterialPagerAdapter: ClassMaterialPagerAdapter
    private val tabName = listOf(
        "Jadwal",
        "Materi",
        "Tugas"
    )

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
            classMaterialPagerAdapter = ClassMaterialPagerAdapter(requireActivity())
            classMaterialViewPager.adapter = classMaterialPagerAdapter
            TabLayoutMediator(classDetailTab, classMaterialViewPager) { tab: TabLayout.Tab, position: Int ->
                tab.text = tabName[position]
            }.attach()

        }
        binding.csUlasan.setOnClickListener {
            val intent = Intent(activity, DetailKelasSayaActivity::class.java)
            startActivity(intent)
        }
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
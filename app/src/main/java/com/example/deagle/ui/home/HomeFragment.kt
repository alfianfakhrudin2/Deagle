package com.example.deagle.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.R
=======
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
>>>>>>> 9d92de3fa4536a80163abff7a1d8636ca4199695
import com.example.deagle.databinding.FragmentHomeBinding
import com.example.deagle.helper.AutoScrollHelper
import com.example.deagle.ui.adapter.ItemAdapter
import com.example.deagle.ui.adapter.KhursusAdapter
import com.example.deagle.ui.adapter.rvHorizontal
import com.example.deagle.ui.adapter.rvKursus
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var autoScrollHelper: AutoScrollHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
=======
        binding.recyclerViewHorizontal.adapter = rvHorizontal()
        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvhorizontal1.adapter = rvKursus()
>>>>>>> 9d92de3fa4536a80163abff7a1d8636ca4199695

        // Hide the action bar
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // Initialize AutoScrollHelper
        autoScrollHelper = AutoScrollHelper(binding.recyclerViewHorizontal)

        // Set up RecyclerView Horizontal
        setupRecyclerViewHorizontal()

        // Set up RecyclerView Horizontal 1
        setupRecyclerViewHorizontal1()

        // Start auto-scrolling
        autoScrollHelper.startAutoScroll()
    }

    private fun setupRecyclerViewHorizontal() {
        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Get list of heroes
        val listHeroes = getListHeroes()

        // Create and set rvHorizontal adapter
        val listHeroAdapter = rvHorizontal(requireContext(), listHeroes)
        binding.recyclerViewHorizontal.adapter = listHeroAdapter

        // Add snap helper for snapping behavior
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerViewHorizontal)
    }

    private fun setupRecyclerViewHorizontal1() {
        binding.rvhorizontal1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Get list of kursus
        val listKursus = getListKursus()

        // Create and set rvKursus adapter
        val kursusAdapter = rvKursus(requireContext(), listKursus)
        binding.rvhorizontal1.adapter = kursusAdapter
    }

    private fun getListHeroes(): ArrayList<ItemAdapter> {
        // Your implementation
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listItems = ArrayList<ItemAdapter>()
        for (i in 0 until dataPhoto.length()) {
            val item = ItemAdapter(dataPhoto.getResourceId(i, -1))
            listItems.add(item)
        }
        dataPhoto.recycle() // Recycle the typed array
        return listItems
    }

    private fun getListKursus(): ArrayList<KhursusAdapter> {
        val dataPhotos = resources.obtainTypedArray(R.array.data_khursus_photo)
        val dataTitles = resources.getStringArray(R.array.data_khursus_title)
        val dataDescs = resources.getStringArray(R.array.data_khursus_desc)
        val dataHarga = resources.getStringArray(R.array.data_harga_khursus)

        val listKursus = ArrayList<KhursusAdapter>()
        for (i in dataTitles.indices) {
            val kursus = KhursusAdapter(
                dataPhotos.getResourceId(i, -1),
                dataTitles[i],
                dataDescs[i],
                dataHarga[i],
            )
            listKursus.add(kursus)
        }
        // Recycle the typed array
        dataPhotos.recycle()
        return listKursus
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        autoScrollHelper.startAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        autoScrollHelper.stopAutoScroll()
    }
}


package com.example.deagle.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deagle.R
import com.example.deagle.databinding.FragmentHomeBinding
import com.example.deagle.ui.adapter.ItemAdapter
import com.example.deagle.ui.adapter.KhursusAdapter
import com.example.deagle.ui.adapter.rvHorizontal
import com.example.deagle.ui.adapter.rvKursus

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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

        // Hide the action bar
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        // Set LinearLayoutManager to recyclerViewHorizontal
        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Get list of heroes
        val listHeroes = getListHeroes()

        // Create and set rvHorizontal adapter
        val listHeroAdapter = rvHorizontal(requireContext(), listHeroes)
        binding.recyclerViewHorizontal.adapter = listHeroAdapter

        // Set LinearLayoutManager to rvhorizontal1
        binding.rvhorizontal1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Get list of kursus
        val listKursus = getListKursus()

        // Create and set rvKursus adapter
        val kursusAdapter = rvKursus(requireContext(), listKursus)
        binding.rvhorizontal1.adapter = kursusAdapter
    }

    private fun getListHeroes(): ArrayList<ItemAdapter> {
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
}


package com.example.deagle.ui.kelas.materi

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deagle.R
import com.example.deagle.data.DataMateri
import com.example.deagle.data.DataSchedule
import com.example.deagle.data.DataSource
import com.example.deagle.databinding.FragmentJadwalBinding
import com.example.deagle.databinding.FragmentMateriBinding
import com.example.deagle.ui.BatalActivity
import com.example.deagle.ui.adapter.MateriAdapter
import com.example.deagle.ui.kelas.jadwal.JadwalViewModel

class MateriFragment : Fragment(), MateriAdapter.OnItemClickCallback {

    private val viewModel: MateriViewModel by viewModels()
    private lateinit var binding: FragmentMateriBinding
    private lateinit var materiAdapter: MateriAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        materiAdapter = MateriAdapter(this)
        materiAdapter.setData(DataSource.dataMateri)
        binding.rvMateri.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMateri.setHasFixedSize(true)
        binding.rvMateri.adapter = materiAdapter
    }

    override fun clickable(dataMateri: DataMateri) {
        val intent = Intent(requireActivity(), BatalActivity::class.java)
        startActivity(intent)
    }

}
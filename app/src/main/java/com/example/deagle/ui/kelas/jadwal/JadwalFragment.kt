package com.example.deagle.ui.kelas.jadwal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deagle.R
import com.example.deagle.data.DataSchedule
import com.example.deagle.data.DataSource
import com.example.deagle.databinding.FragmentJadwalBinding
import com.example.deagle.ui.DetailClassActivity
import com.example.deagle.ui.DetailSesiActivity
import com.example.deagle.ui.adapter.JadwalAdapter

class JadwalFragment : Fragment(), JadwalAdapter.OnItemClickCallback {

    private val viewModel: JadwalViewModel by viewModels()
    private lateinit var binding: FragmentJadwalBinding
    private lateinit var jadwalAdapter: JadwalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJadwalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.rvJadwal.adapter = JadwalAdapter(
//            this
//        )
        jadwalAdapter = JadwalAdapter(this)
        jadwalAdapter.setData(DataSource.dataSchedule)
        binding.rvJadwal.layoutManager = LinearLayoutManager(requireContext())
        binding.rvJadwal.setHasFixedSize(true)
        binding.rvJadwal.adapter = jadwalAdapter

    }

    override fun clickable(dataSchedule: DataSchedule) {
        val intent = Intent(requireActivity(), DetailSesiActivity::class.java)
        startActivity(intent)
    }
}

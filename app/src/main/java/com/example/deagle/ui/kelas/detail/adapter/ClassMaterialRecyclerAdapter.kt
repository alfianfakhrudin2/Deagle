package com.example.deagle.ui.kelas.detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.deagle.data.DeagleClassMaterial
import com.example.deagle.databinding.ClassMaterialItemBinding

class ClassMaterialRecyclerAdapter(val data: List<DeagleClassMaterial>) : RecyclerView.Adapter<ClassMaterialRecyclerAdapter.ClassMaterialViewHolder>() {

    private lateinit var binding: ClassMaterialItemBinding

    inner class ClassMaterialViewHolder() : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassMaterialViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ClassMaterialViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
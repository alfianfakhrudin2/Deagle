package com.example.deagle.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.R
import com.example.deagle.data.DataSchedule
import com.example.deagle.databinding.JadwalItemBinding
import com.example.deagle.ui.kelas.detail.adapter.ClassMaterialRecyclerAdapter

class JadwalAdapter(private val onItemClickCallback: OnItemClickCallback): RecyclerView.Adapter<JadwalAdapter.ViewHolder>(){

    private lateinit var data: List<DataSchedule>
    fun setData(data: List<DataSchedule>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = JadwalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, this.onItemClickCallback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.binding.apply {
            tvDate.text = item.date
            tvTitle.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return 25
    }

    inner class ViewHolder(val binding: JadwalItemBinding, val onItemClickCallback: OnItemClickCallback): RecyclerView.ViewHolder(binding.root) {
        init {
            this.binding.root.setOnClickListener {
                this.onItemClickCallback.clickable(data[adapterPosition])
            }
        }
    }

    interface OnItemClickCallback {
        fun clickable(dataSchedule: DataSchedule)
    }
}

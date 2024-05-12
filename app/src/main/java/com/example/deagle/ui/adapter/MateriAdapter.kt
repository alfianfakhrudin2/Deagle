package com.example.deagle.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.data.DataMateri
import com.example.deagle.databinding.MateriItemBinding

class MateriAdapter(private val onItemClickCallback: OnItemClickCallback) : RecyclerView.Adapter<MateriAdapter.ViewHolder>() {
    private lateinit var data: List<DataMateri>

    fun setData(data: List<DataMateri>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MateriItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onItemClickCallback)
    }

    override fun getItemCount(): Int {
        return if (::data.isInitialized) data.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: MateriItemBinding, private val onItemClickCallback: OnItemClickCallback) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onItemClickCallback.clickable(data[adapterPosition])
            }
        }

        fun bind(item: DataMateri) {
            binding.apply {
                tvTitleStatus.text = item.title
                tvStatusMateri.text = item.status
            }
        }
    }

    interface OnItemClickCallback {
        fun clickable(dataMateri: DataMateri)
    }
}

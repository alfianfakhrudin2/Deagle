package com.example.deagle.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.databinding.ItemKursusBinding
import com.example.deagle.ui.DetailPembelianActivity

class rvKursus(private val context: Context, private val itemList: ArrayList<KhursusAdapter>) :
    RecyclerView.Adapter<rvKursus.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemKursusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemList.size

    inner class ListViewHolder(private val binding: ItemKursusBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: KhursusAdapter) {
            binding.apply {
                // Bind data to views
                ivKhursus .setImageResource(item.photo)
                tvTitleKhursus.text = item.nama
                tvHargaKursus.text = item.harga
                tvDescriptionKhursus.text = item.deskripsi
            }
        }

        override fun onClick(v: View?) {
            // Redirect to DetailPembelianActivity when clicked
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val intent = Intent(context, DetailPembelianActivity::class.java)
                intent.putExtra("kursus_title", itemList[position].nama)
                intent.putExtra("kursus_desc", itemList[position].deskripsi)
                intent.putExtra("kursus_harga", itemList[position].harga)
                context.startActivity(intent)
            }
        }
    }
}

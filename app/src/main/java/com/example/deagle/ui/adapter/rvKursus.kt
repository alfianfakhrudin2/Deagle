package com.example.deagle.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.deagle.R

class rvKursus(private val context: Context, private val itemList: ArrayList<KhursusAdapter>) : RecyclerView.Adapter<rvKursus.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvKursus.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kursus, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = itemList[position]
        holder.imgPhoto.setImageResource(item.photo)
    }

    override fun getItemCount(): Int = itemList.size


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_khursus)
    }
}
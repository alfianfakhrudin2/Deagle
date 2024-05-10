package com.example.deagle.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.deagle.R


class rvHorizontal(private val context: Context, private val itemList: ArrayList<ItemAdapter>) : RecyclerView.Adapter<rvHorizontal.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = itemList[position]
        holder.imgPhoto.setImageResource(item.foto)

//        holder.itemView.setOnClickListener {
//            val intentDetail = Intent(context, DetailActivity::class.java)
//            intentDetail.putExtra("key_hero", item)
//            context.startActivity(intentDetail)
//        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_hero)
    }
}






package com.example.deagle.ui.kelas.detail.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.deagle.R
import com.example.deagle.data.DeagleClassMaterial
import com.example.deagle.databinding.ClassMaterialItemBinding

class ClassMaterialRecyclerAdapter(
    private val onItemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<ClassMaterialRecyclerAdapter.ClassMaterialViewHolder>() {


    private lateinit var data: List<DeagleClassMaterial>
    fun setData(data: List<DeagleClassMaterial>) {
        this.data = data
    }
    inner class ClassMaterialViewHolder(val binding: ClassMaterialItemBinding, val onItemClickCallback: OnItemClickCallback) : RecyclerView.ViewHolder(binding.root) {
        init {
            this.binding.root.setOnClickListener {
                this.onItemClickCallback.clickable(data[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassMaterialRecyclerAdapter.ClassMaterialViewHolder {
        val binding = ClassMaterialItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassMaterialViewHolder(binding, this.onItemClickCallback)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ClassMaterialRecyclerAdapter.ClassMaterialViewHolder, position: Int) {
        val item = data[position]
        holder.binding.apply {
            classMaterialTitleText.text = item.title
            classMaterialStatusIcon.setImageResource(item.statusIcon!!)
            classMaterialDeadlineText.text = item.deadline
            classMaterialStatusFinishedText.text = if (item.isFinished) {
                classMaterialStatusText.visibility = View.GONE
                classMaterialStatusIcon.visibility = View.GONE
                classMaterialDeadlineText.visibility = View.GONE
                classMaterialStatusFinishedText.visibility = View.VISIBLE
                classMaterialDeadlineFinishedText.visibility = View.VISIBLE
                "Selesai"
            } else {
                ""
            }
            classMaterialDeadlineFinishedText.text = if (item.isFinished && item.finishDate != null) {
                classMaterialStatusText.visibility = View.GONE
                classMaterialStatusIcon.visibility = View.GONE
                classMaterialDeadlineText.visibility = View.GONE
                classMaterialStatusFinishedText.visibility = View.VISIBLE
                classMaterialDeadlineFinishedText.visibility = View.VISIBLE
                item.finishDate
            } else {
                ""
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickCallback {
        fun clickable(deagleClassMaterial: DeagleClassMaterial)
    }
}
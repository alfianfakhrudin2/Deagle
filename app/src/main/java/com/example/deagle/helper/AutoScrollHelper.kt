package com.example.deagle.helper

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AutoScrollHelper(private val recyclerView: RecyclerView) {
    private var timer: Timer? = null
    private val delayTime = 2000L // Ubah delay time sesuai kebutuhan Anda
    private var currentIndex = 0 // Indeks item saat ini

    fun startAutoScroll() {
        stopAutoScroll() // Stop previous scrolling if any
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                recyclerView.post {
                    val layoutManager = recyclerView.layoutManager as? LinearLayoutManager
                    layoutManager?.let {
                        // Smooth scroll ke indeks berikutnya
                        smoothScrollToPosition(currentIndex)
                        // Update indeks untuk berikutnya
                        currentIndex = (currentIndex + 1) % (recyclerView.adapter?.itemCount ?: 1)
                    }
                }
            }
        }, delayTime, delayTime) // Periode delay untuk autoplay
    }

    fun stopAutoScroll() {
        timer?.cancel()
        timer = null
    }

    private fun smoothScrollToPosition(position: Int) {
        val smoothScroller = object : LinearSmoothScroller(recyclerView.context) {
            override fun getVerticalSnapPreference(): Int = SNAP_TO_START
            override fun getHorizontalSnapPreference(): Int = SNAP_TO_START
        }
        smoothScroller.targetPosition = position
        (recyclerView.layoutManager as? LinearLayoutManager)?.startSmoothScroll(smoothScroller)
    }
}



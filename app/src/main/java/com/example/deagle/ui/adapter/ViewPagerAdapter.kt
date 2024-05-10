package com.example.deagle.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.deagle.R

class ViewPagerAdapter(var context: Context) : PagerAdapter() {
    var sliderAllImages: IntArray = intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )
    var sliderAllTitle: IntArray = intArrayOf(
        R.string.screen1,
        R.string.screen2,
        R.string.screen3,
        R.string.screen4,
        R.string.screen5
    )
    var sliderAllDesc: IntArray = intArrayOf(
        R.string.screen1desc,
        R.string.screen2desc,
        R.string.screen3desc,
        R.string.screen4desc,
        R.string.screen5desc
    )

    override fun getCount(): Int {
        return sliderAllTitle.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.slider_screen, container, false)
        val sliderImage = view.findViewById<ImageView>(R.id.sliderImage)
        val sliderTitle = view.findViewById<TextView>(R.id.sliderTitle)
        val sliderDesc = view.findViewById<TextView>(R.id.sliderDesc)
        sliderImage.setImageResource(sliderAllImages[position])
        sliderTitle.setText(sliderAllTitle[position])
        sliderDesc.setText(sliderAllDesc[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}

package com.example.deagle.ui

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.deagle.MainActivity
import com.example.deagle.R
import com.example.deagle.ui.adapter.ViewPagerAdapter

class OnboardingActivity : AppCompatActivity() {
    private lateinit var slideViewPager: ViewPager

    private lateinit var backButton: Button
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button
    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPagerAdapter
//    private val viewPagerListener = object : OnPageChangeListener {
//        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
//
//        override fun onPageSelected(position: Int) {
//            setDotIndicator(position)
//            backButton.visibility = if (position > 0) View.VISIBLE else View.INVISIBLE
//            nextButton.text = if (position == 4) "Finish" else "Next" // Adjusted for 5 screens
//        }
//
//
//        private fun getItem(i: Int): Int {
//            return slideViewPager.currentItem + i
//        }
//
//        override fun onPageScrollStateChanged(state: Int) {}
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        backButton = findViewById(R.id.backButton)
        nextButton = findViewById(R.id.nextButton)
        skipButton = findViewById(R.id.skipButton)
        slideViewPager = findViewById(R.id.slideViewPager)
        viewPagerAdapter = ViewPagerAdapter(this)
        slideViewPager.adapter = viewPagerAdapter
        setDotIndicator(0)
//        slideViewPager.addOnPageChangeListener(viewPagerListener)

        supportActionBar?.hide()

        backButton.setOnClickListener {
            if (getItem(0) > 0) {
                slideViewPager.setCurrentItem(getItem(-1), true)
            }
        }

        nextButton.setOnClickListener {
            if (getItem(0) < 4) { // Adjusted for 5 screens
                slideViewPager.setCurrentItem(getItem(1), true)
            } else {
                val i = Intent(this@OnboardingActivity, StartActivity::class.java) // Changed to MainActivity
                startActivity(i)
                finish()
            }
        }


        skipButton.setOnClickListener {
            val i = Intent(this@OnboardingActivity, StartActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun setDotIndicator(position: Int) {
        dots = arrayOfNulls<TextView?>(5)
//        dotIndicator.removeAllViews()
//        for (i in dots.indices) {
//            dots[i] = TextView(this)
//            dots[i]?.text = Html.fromHtml("&#8226;")
//            dots[i]?.textSize = 35f
//            dots[i]?.setTextColor(ContextCompat.getColor(this, R.color.desc))
//            dotIndicator.addView(dots[i])
//        }
        dots[position]?.setTextColor(ContextCompat.getColor(this, R.color.fonts))
    }

    private fun getItem(i: Int): Int {
        return slideViewPager.currentItem + i
    }
}

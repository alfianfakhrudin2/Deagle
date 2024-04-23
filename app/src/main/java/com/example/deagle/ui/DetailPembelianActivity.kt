package com.example.deagle.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.deagle.R
import com.example.deagle.databinding.ActivityDetailPembelianBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class DetailPembelianActivity : AppCompatActivity() {

    private lateinit var uid: MaterialCardView
    private lateinit var whatIsUID: MaterialTextView
    private lateinit var arrowUID: ImageView
    private lateinit var line: View
    private var click = 0
    private lateinit var binding: ActivityDetailPembelianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailPembelianBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        uid = findViewById(R.id.uid)
//        whatIsUID = findViewById<MaterialTextView>(R.id.apainiuid)
//        arrowUID = findViewById(R.id.arrowUID)
//        line = findViewById(R.id.line)
//
//        uid.setOnClickListener {
//            TransitionManager.beginDelayedTransition(uid)
//            if (click % 2 == 0) {
//                whatIsUID.animate()
//                    .alpha(1f)
//                    .setDuration(300)
//                    .setListener(object : AnimatorListenerAdapter() {
//                        override fun onAnimationEnd(animation: Animator) {
//                            whatIsUID.visibility = View.VISIBLE
//                            line.visibility = View.VISIBLE
//                            super.onAnimationEnd(animation)
//                        }
//                    })
//                arrowUID.setImageResource(R.drawable.dropup)
//            } else {
//                whatIsUID.animate()
//                    .alpha(0f)
//                    .setDuration(300)
//                    .setListener(object : AnimatorListenerAdapter() {
//                        override fun onAnimationEnd(animation: Animator) {
//                            whatIsUID.visibility = View.GONE
//                            line.visibility = View.GONE
//                            super.onAnimationEnd(animation)
//                        }
//                    })
//                arrowUID.setImageResource(R.drawable.dropdown)
//            }
//            click++
//        }
    }
}

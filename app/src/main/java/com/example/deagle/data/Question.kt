package com.example.deagle.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable

data class Question(
    val question: String,
    val answers: List<Answer>
)

data class Answer(
    val answer: String,
    var isSelected: Boolean
)
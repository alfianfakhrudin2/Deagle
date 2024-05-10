package com.example.deagle.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val question: String,
    val answers: List<Answer>
) : Parcelable {


}

@Parcelize
data class Answer(
    val answer: String,
    var isSelected: Boolean,
    val isRightAnswer: Boolean
) : Parcelable {


}
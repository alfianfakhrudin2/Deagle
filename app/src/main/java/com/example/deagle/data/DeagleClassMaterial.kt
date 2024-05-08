package com.example.deagle.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import java.io.Serializable

data class DeagleClassMaterial(
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val workingTime: String,
    val deadline: String,
    var isFinished: Boolean,
    var statusIcon: Int?,
    var finishDate: String?,
    val questions: List<Question>
)

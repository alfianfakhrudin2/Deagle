package com.example.deagle.data

data class DeagleClassMaterial(
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val workingTime: String,
    val deadline: String,
    val isFinished: Boolean,
    var statusIcon: Int?,
    var finishDate: String?,
    val questions: List<Question>
)

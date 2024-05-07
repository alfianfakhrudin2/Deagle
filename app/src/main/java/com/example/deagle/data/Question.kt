package com.example.deagle.data

data class Question(
    val question: String,
    val answers: List<Answer>
)

data class Answer(
    val answer: String,
    var isSelected: Boolean
)

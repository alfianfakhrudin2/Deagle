package com.example.deagle.ui.kelas.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deagle.data.Question

class AnswerViewModel : ViewModel() {
    private var _question = MutableLiveData<Question>()
    val question: LiveData<Question> = _question

    fun addQuestion(question: Question) {
        _question.value = question
    }
}
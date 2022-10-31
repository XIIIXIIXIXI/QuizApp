package com.example.quizapp.presentation

import com.example.quizapp.domain.model.Question

data class QuizState(
    val questions: List<Question> = emptyList()
)

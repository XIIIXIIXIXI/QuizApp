package com.example.quizapp.presentation

import com.example.quizapp.domain.model.Question

data class QuizState(
    val questions: List<Question> = emptyList(),
    val selectedDifficulty: String = "Easy",
    val nQuestions: Int = 10,
    val category: String = "s",
    val isLoading: Boolean = false,
    val error: String? =null
)

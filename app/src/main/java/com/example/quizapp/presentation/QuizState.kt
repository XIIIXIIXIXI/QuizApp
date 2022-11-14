package com.example.quizapp.presentation

import com.example.quizapp.domain.model.Question

data class QuizState(
    val questions: List<Question> = emptyList(),
    val selectedDifficulty: String = "Easy",
    val nQuestions: Int = 10,
    val category: String = "s",
    val currentQuestionNumber: Int = 0,
    val shuffledAnswers: List<String> = emptyList(),

    //UI STUFF
    //composable answerOption: unanswered, answerCorrect, answerWrong
    val answerStatus: List<String> = listOf("", "", "", ""),
    val isLoading: Boolean = false,
    val error: String? =null,
)

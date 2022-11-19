package com.example.quizapp.presentation

import com.example.quizapp.domain.model.Question

/**
 * This data class represents the view state for the [GameScreen].
 * All of this data should be formatted in a way that the game screen can just
 * take the information and display it.
 */

data class QuizState(
    val questions: List<Question> = emptyList(),
    val selectedDifficulty: String = "Easy",
    val nQuestions: Int = 10,
    val category: String = "s",
    val currentQuestionNumber: Int = 0,

    val shuffledAnswers: List<String> = emptyList(),
    val saveAnswer: MutableList<String> = mutableListOf(),


    //UI STUFF
    //composable answerOption: unanswered, answerCorrect, answerWrong
    val answerStatus: List<String> = listOf("", "", "", ""),
    val isLoading: Boolean = false,
    val error: String? =null,
    val pressToContinue: Boolean = false,
    val gameOver: Boolean = false

)

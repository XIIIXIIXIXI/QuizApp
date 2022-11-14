package com.example.quizapp.domain.model

import androidx.compose.ui.graphics.Color

data class QuestionData(
    val questions: List<Question>
)

data class Question(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String,
    val answerStatus: Int
)

data class QuestionTestState(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String,
    val answerStatus: Int
)

val  questions = listOf(
        QuestionTestState(
            "General Knowledge",
            "Tango",
            "easy",
            listOf("Target", "Taxt", "Turkey"),
            "What word represents the letter &#039;T&#039; in the NATO phonetic alphabet?",
            "multiple",
            0
        ),
        QuestionTestState(
            "General Knowledge",
            "Ed Sheeran - I See Fire",
            "hard",
            listOf(
                "Marvin Gate - Sexual Healing",
                "Coldplay - Midnight",
                "a-ha - Take on me"
            ),
            "Electronic music producer Kygo&#039;s popularity skyrocketed after a certain remix. Which song did he remix?",
            "multiple",
            1
        )
    )






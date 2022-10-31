package com.example.quizapp.data.remote

data class QuestionList(
    val response_code: Int,
    val results: List<Result>
)
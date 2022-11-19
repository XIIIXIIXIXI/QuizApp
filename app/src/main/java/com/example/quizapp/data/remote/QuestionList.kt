package com.example.quizapp.data.remote

/**
 * Remote data object
 */

data class QuestionList(
    val response_code: Int,
    val results: List<Result>
)
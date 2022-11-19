package com.example.quizapp.data

import com.example.quizapp.data.remote.QuestionList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This allows the user to request questions from the api
 *
 * Interface is used so that we can create multiple implemntations and swap them out easily.
 */

interface QuizApi {

    @GET("api.php")
    suspend fun getQuestionList(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): QuestionList
}
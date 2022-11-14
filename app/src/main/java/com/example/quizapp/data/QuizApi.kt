package com.example.quizapp.data

import com.example.quizapp.data.remote.QuestionList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface QuizApi {

    @GET("api.php")
    suspend fun getQuestionList(
        @Query("amount") amount: Int,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String = "multiple"
    ): QuestionList
}
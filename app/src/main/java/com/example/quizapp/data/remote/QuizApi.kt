package com.example.quizapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path


interface QuizApi {

    @GET("api.php?amount={10}&category={9}&difficulty={easy}&type=multiple")
    suspend fun getQuestionList(
        @Path("10") amount: Int,
        @Path("9") category: Int,
        @Path("easy") difficulty: String
    ): QuestionList
}
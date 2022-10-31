package com.example.quizapp.data

import com.example.quizapp.data.remote.QuestionList
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.domain.util.Resource
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val api: QuizApi
): QuizRepository{
    override suspend fun getQuestionList(
        amount: Int,
        category: Int,
        difficulty: String
    ): Resource<QuestionList> {
        val response = try {
            api.getQuestionList(amount, category, difficulty)
        } catch (e: Exception) {
            return Resource.Error("An error occured")
        }
        return Resource.Success(response)
    }

}
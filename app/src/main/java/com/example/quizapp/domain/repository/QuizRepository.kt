package com.example.quizapp.domain.repository

import com.example.quizapp.data.remote.QuestionList
import com.example.quizapp.util.Resource

interface QuizRepository {
    suspend fun getQuestionList(amount: Int, category: Int, difficulty: String): Resource<QuestionList>
}
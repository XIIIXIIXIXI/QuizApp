package com.example.quizapp.domain.repository

import com.example.quizapp.data.remote.QuestionList
import com.example.quizapp.util.Resource

/**
 * [QuizRepository] serves as  the model layer for our Main viewmodel. This allows the logic to request
 * a list of questions that will then get passed to the viewmodel.
 *
 * Interface is used so  that we can create multiple implemntations and swap them out
 */

interface QuizRepository {
    suspend fun getQuestionList(amount: Int, category: Int, difficulty: String): Resource<QuestionList>
}
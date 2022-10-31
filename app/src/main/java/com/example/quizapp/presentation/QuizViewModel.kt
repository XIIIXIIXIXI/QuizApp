package com.example.quizapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.model.Question
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel() {

    private val _state = mutableStateOf(QuizState())
    val state: State<QuizState> = _state

    init {
        loadQuestions()
    }

    fun loadQuestions(){
        viewModelScope.launch {
            val result = repository.getQuestionList(10, 9, "easy")
            when(result){
                is Resource.Success -> {
                    val resultList = result.data!!.results.mapIndexed { index, entry ->
                        Question(entry.category, entry.correct_answer, entry.difficulty, entry.incorrect_answers, entry.question, entry.type)
                    }
                    _state.value = _state.value.copy(
                        questions = resultList
                    )
                }
                is Resource.Error -> {
                    println("Error asjdfkas fjk")
                }
            }

        }
    }
}
package com.example.quizapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.model.Question
import com.example.quizapp.domain.model.categoryMap
import com.example.quizapp.domain.repository.QuizRepository
import com.example.quizapp.presentation.categoryScreens.selectedCatScreen.SelectedCategoryState
import com.example.quizapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuizRepository,
    private val savedStateHandle: SavedStateHandle //used for passing argument to viewmodel from navigation
) : ViewModel() {

    private val _state = mutableStateOf(QuizState())
    val state: State<QuizState> = _state

    init{
        loadQuestions()
    }

/*
    fun loadQuestions(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val result = repository.getQuestionList(10, categoryMap["history"]!!, "easy")
            when(result){
                is Resource.Success -> {
                    val resultList = result.data!!.results.mapIndexed { index, entry ->
                        Question(entry.category, entry.correct_answer, entry.difficulty, entry.incorrect_answers, entry.question, entry.type)
                    }
                    _state.value = _state.value.copy(
                        questions = resultList,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                }
            }

        }
    }
*/

    fun loadQuestions(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            val category = savedStateHandle.get<String>("category")
            val nQuestions = savedStateHandle.get<Int>("nQuestions") ?: return@launch //ellers brokker den sig med nullable
            var difficulty = savedStateHandle.get<String>("difficulty") ?: return@launch
            difficulty = difficulty.replaceFirstChar { it.lowercase() }
            val result = repository.getQuestionList(nQuestions, categoryMap[category]!!, difficulty)
            when(result){
                is Resource.Success -> {
                    val resultList = result.data!!.results.mapIndexed {index, entry ->
                        Question(entry.category, entry.correct_answer, entry.difficulty, entry.incorrect_answers, entry.question, entry.type, 0)
                    }
                    _state.value = _state.value.copy(
                        questions = resultList,
                    )
                    shuffleAnswers(0)
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    println("an error accured when fetching data from API")
                }
            }
        }
    }

    fun shuffleAnswers(questionNumber: Int){
        val questions = _state.value.questions
        val listToShuffle: MutableList<String> = mutableListOf()
        for (answer in questions[questionNumber].incorrect_answers){
            listToShuffle.add(answer)
        }
        listToShuffle.add(questions[questionNumber].correct_answer)
        listToShuffle.shuffle()
        _state.value = _state.value.copy(
            shuffledAnswers = listToShuffle
        )

    }


}
package com.example.quizapp.presentation.categoryScreens.selectedCatScreen


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedCategoryViewModel: ViewModel() {

    private val _state = MutableStateFlow(SelectedCategoryState())
    val state = _state.asStateFlow()

    fun changeDifficulty(difficulty: String){
        _state.value = _state.value.copy(
            selectedDifficulty = difficulty
        )
    }
    fun changeNQuestions(number: Int){
        _state.value = _state.value.copy(
            nQuestions = number
        )
    }
}
package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizapp.domain.model.colorMap
import com.example.quizapp.presentation.categoryScreens.selectedCatScreen.SelectedCategoryViewModel
import com.example.quizapp.presentation.composables.TopAppBar
import com.example.quizapp.presentation.destinations.GameScreenDestination
import com.example.quizapp.presentation.destinations.SelectedCategoryScreenDestination
import com.example.quizapp.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination
fun SelectedCategoryScreen(
    navigator: DestinationsNavigator,
    category: String,
    viewModel: SelectedCategoryViewModel = viewModel<SelectedCategoryViewModel>(),
){
    TopAppBar(screenName = category)
    Box {
        LazyColumn(contentPadding = PaddingValues(top = TopBarExpendedHeight)){
            item{
                ChooseDifficultyHeader(viewModel)
                CircularProcess(viewModel, category)
                PlayButton(viewModel, category, navigator)
            }
        }
    }
}

@Composable
fun PlayButton(viewModel: SelectedCategoryViewModel, category: String, navigator: DestinationsNavigator) {
    val state by viewModel.state.collectAsState()
    Spacer(modifier = Modifier.height(40.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center ) {
        TextButton(onClick = { navigator.navigate(
            GameScreenDestination(
                category,
                state.nQuestions,
                state.selectedDifficulty)) })
        {
            Text(
                text = "- press to continue -",
                modifier = Modifier.padding(horizontal = 36.dp, vertical = 20.dp),
                fontSize = 25.sp
            )
        }
        }
    }
//navigator.navigate(GameScreenDestination(category, state.nQuestions, state.selectedDifficulty))



@Composable
fun CircularProcess(viewModel: SelectedCategoryViewModel, category: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(top = 16.dp,)
            ,
        contentAlignment = Alignment.Center
    ){
        CircularDragger(
            modifier = Modifier
                .size(250.dp)
                .background(Color.Gray),
            initialValue = 10,
            colorOne = colorMap[category] as Color,
            colorTwo = Color.Gray,
            circleRadius = 390f,
            onChange = {position ->
                viewModel.changeNQuestions(position)
            })
    }
}

@Composable
fun ChooseDifficultyHeader(
    viewModel: SelectedCategoryViewModel
) {
    val state by viewModel.state.collectAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(90.dp)
    ){
        SelectedCategoryDifficulty(Modifier.weight(1f), state.selectedDifficulty, "Easy", ColorDifficultyEasy){ difficulty ->
            viewModel.changeDifficulty(difficulty)
        }
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), state.selectedDifficulty, difficulty = "Medium", ColorDifficultyMedium){ difficulty ->
            viewModel.changeDifficulty(difficulty)
        }
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), state.selectedDifficulty, difficulty = "Hard", ColorDifficultyHard){ difficulty ->
            viewModel.changeDifficulty(difficulty)
        }
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(90.dp)
    ){
        SelectedCategoryDifficulty(modifier = Modifier, state.selectedDifficulty, difficulty = "All Difficulty", color = ColorDifficultyAll){ difficulty ->
            viewModel.changeDifficulty("All Difficulty")
        }
    }
}

@Composable
@Preview
fun SelectedCategoryScreenPreview() {
    QuizAppTheme {
        Surface(
            color = colors.background,
        ) {
      //      SelectedCategoryScreen(category = "History")
        }
    }
}
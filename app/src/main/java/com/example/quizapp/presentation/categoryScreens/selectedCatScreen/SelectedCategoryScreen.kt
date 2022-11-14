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

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizapp.presentation.categoryScreens.selectedCatScreen.SelectedCategoryViewModel
import com.example.quizapp.presentation.composables.TopAppBar
import com.example.quizapp.presentation.destinations.GameScreenDestination
import com.example.quizapp.presentation.destinations.SelectedCategoryScreenDestination
import com.example.quizapp.ui.theme.ColorHistory
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.TopBarExpendedHeight
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
                CircularProcess(viewModel)
                PlayButton(viewModel, category, navigator)
            }
        }
    }
}

@Composable
fun PlayButton(viewModel: SelectedCategoryViewModel, category: String, navigator: DestinationsNavigator) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 55.dp, vertical = 5.dp)
    ){
        Button(
            onClick = { navigator.navigate(
                GameScreenDestination(category, state.nQuestions, state.selectedDifficulty)
            ) },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
               // .padding(20.dp )
            ,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta, contentColor = Color.Black
            )
        ) {
            Text("START")
        }
    }
}

@Composable
fun CircularProcess(viewModel: SelectedCategoryViewModel) {

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
            colorOne = ColorHistory,
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
        SelectedCategoryDifficulty(Modifier.weight(1f), state.selectedDifficulty, "Easy", Color.Green){ difficulty ->
            viewModel.changeDifficulty(difficulty)
        }
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), state.selectedDifficulty, difficulty = "Medium", Color.Yellow){ difficulty ->
            viewModel.changeDifficulty(difficulty)
        }
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), state.selectedDifficulty, difficulty = "Hard", Color.Red){ difficulty ->
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
        SelectedCategoryDifficulty(modifier = Modifier, state.selectedDifficulty, difficulty = "All Difficulty", color = Color.LightGray){ difficulty ->
            viewModel.changeDifficulty(difficulty)
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
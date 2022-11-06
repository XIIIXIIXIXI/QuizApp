package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.presentation.composables.TopAppBar
import com.example.quizapp.ui.theme.ColorHistory
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.Shapes
import com.example.quizapp.ui.theme.TopBarExpendedHeight
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun SelectedCategoryScreen(
    category: String
){
    TopAppBar(screenName = category)
    Box {
        LazyColumn(contentPadding = PaddingValues(top = TopBarExpendedHeight)){
            item{
                ChooseDifficultyHeader()
                CircularProcess()
            }
        }
    }
}

@Composable
fun CircularProcess() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding( 16.dp)
            ,
        contentAlignment = Alignment.Center
    ){
        CircularDragger(
            modifier = Modifier.size(250.dp)
                .background(Color.Gray),
            initialValue = 1,
            colorOne = ColorHistory,
            colorTwo = Color.Gray,
            circleRadius = 230f,
            onChange = {position ->
                //do something with this
            })
    }
}

@Composable
fun ChooseDifficultyHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(90.dp)
    ){
        SelectedCategoryDifficulty(Modifier.weight(1f), true, "Easy", Color.Green)
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), selected = false, difficulty = "Medium", Color.Yellow)
        SelectedCategoryDifficulty(modifier = Modifier.weight(1f), selected = false, difficulty = "Hard", Color.Red)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(90.dp)
    ){
        SelectedCategoryDifficulty(modifier = Modifier, selected = true, difficulty = "All Difficulty", color = Color.LightGray)
    }
}

@Composable
@Preview
fun SelectedCategoryScreenPreview() {
    QuizAppTheme {
        Surface(
            color = colors.background
        ) {
            SelectedCategoryScreen(category = "History")
        }
    }
}
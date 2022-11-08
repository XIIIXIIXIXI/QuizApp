package com.example.quizapp.presentation.gameScreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.SecondaryGameScreen
import com.example.quizapp.ui.theme.TopBarExpendedHeight
import com.example.quizapp.domain.model.questions


@Composable
fun GameScreen(){
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            CategoryTopBar(category = "history")
            QuestionNumber(10)
            QuestionLine(2)
        }
}

@Composable
fun QuestionLine(nQuestions: Int) {
    val paddingWidth = 8
    Spacer(modifier = Modifier.height(10.dp))
    Canvas(modifier = Modifier.padding(paddingWidth.dp).background(MaterialTheme.colors.background).fillMaxWidth().height(30.dp)){
        val canvasWidth = size.width
        val canvasHeight = size.height

        val space = 60f
//        val space2 = 60f
        val squareHeight = canvasHeight / 2
        val squareWidth = (((canvasWidth - (nQuestions-1) * space ) / nQuestions))
        for (i in questions.indices){
            drawRect(
                color = if (questions[i].answerStatus == 0){
                    Color.Gray
                } else if (questions[i].answerStatus == 1){
                    Color.Green
                } else {
                    Color.Red
                },
                topLeft = Offset( (i * space + i * squareWidth) * i, squareHeight / 2),
                size = Size(squareWidth, squareHeight)
            )
        }

    }
}

@Composable
fun QuestionNumber(nQuestions: Int) {
}

@Composable
fun CategoryTopBar(category: String){
    TopAppBar(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp),
        modifier = Modifier.height(TopBarExpendedHeight),
        backgroundColor = MaterialTheme.colors.background
    ){
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Start) {
            Text(
                text = category.uppercase(),
                color = SecondaryGameScreen,
                fontSize = 20.sp,
            )
        }
    }
}

@Preview
@Composable
fun GameScreenPreview(){
    QuizAppTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            GameScreen()
        }
    }
}
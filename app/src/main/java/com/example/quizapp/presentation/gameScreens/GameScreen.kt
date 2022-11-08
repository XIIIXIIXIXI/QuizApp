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
import androidx.compose.ui.text.font.FontWeight
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
        val currentNumber = 6
        val nQuestions = 20
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
 //           CategoryTopBar(category = "history")
            val category = "history"
            Text(
                text = category.uppercase(),
                modifier = Modifier.padding(start = 36.dp, top = 20.dp),
                color = SecondaryGameScreen,
                fontSize = 22.sp
            )
            
            Row(modifier = Modifier.fillMaxWidth().padding(start = 36.dp, top = 3.dp ), horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Question", modifier = Modifier.padding(top = 5.dp),
                    color = Color.White,
                    fontSize = 40.sp,
                )
                Text(
                    text = "$currentNumber",
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.White,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "/$nQuestions",
                    color = SecondaryGameScreen,
                    fontSize = 33.sp,
                    modifier = Modifier.padding(top = 13.dp)
                )
            }
            
            QuestionNumber(10)
            QuestionLine(2)
            
        }
}

@Composable
fun QuestionLine(nQuestions: Int) {

    val paddingWidth = 24
//    Spacer(modifier = Modifier.height(5.dp))
    Canvas(modifier = Modifier
        .padding(paddingWidth.dp)
        .background(MaterialTheme.colors.background)
        .fillMaxWidth()
        .height(20.dp)){
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

/*
@Composable
fun CategoryTopBar(category: String){
    TopAppBar(
        contentPadding = PaddingValues(horizontal = 36.dp, vertical = 15.dp),
        modifier = Modifier.height(TopBarExpendedHeight),
        backgroundColor = MaterialTheme.colors.background
    ){
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Start) {
            Text(
                text = category.uppercase(),
                color = SecondaryGameScreen,
                fontSize = 30.sp,
            )
        }
    }
}
*/
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
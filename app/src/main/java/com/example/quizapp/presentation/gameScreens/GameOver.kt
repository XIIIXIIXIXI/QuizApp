package com.example.quizapp.presentation.gameScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.presentation.QuizViewModel
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.SecondaryGameScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun GameOver(navigator: DestinationsNavigator, viewModel: QuizViewModel

){
    val state = viewModel.state.value
    val listState = rememberLazyListState()
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxSize()) {
        Text(
            text = "You got 5 out of 20 answers right"
        )
        Spacer(modifier = Modifier.height(40.dp))
        LazyRow(state = listState,

            content = {
            items(state.questions.size) {index ->
                AnswerOverview(question = state.questions[index].question ,
                    myAnswer = state.saveAnswer[index],
                    rightAnswer = state.questions[index].correct_answer,
                    modifier = Modifier.padding(16.dp))
            }
        })
    }
}

@Composable
fun AnswerOverview(
    question: String,
    myAnswer: String,
    rightAnswer: String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.width(380.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
        ) {
        Text(
            text = question,
            modifier = Modifier.padding(horizontal = 13.dp),
            color = if (myAnswer == rightAnswer)Color.Green else Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(45.dp))
        Column(modifier = Modifier.padding(horizontal = 13.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            if (myAnswer == rightAnswer){
                AnswerOptionModified(myAnswer, Color.Green)
            }else{
                AnswerOptionModified(answer = myAnswer, color = Color.Red)
                AnswerOptionModified(answer = rightAnswer, color = Color.Green)
            }
        }

    }
}

@Composable
fun AnswerOptionModified(answer: String,  color: Color) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(15.dp), clip = true)
            .background(Color(MaterialTheme.colors.background.value))
            .border(
                BorderStroke(
                    2.dp, color = color

                ),
                shape = RoundedCornerShape(15.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1.2f),
            text = answer,
            color = Color.White,
            style = TextStyle(fontSize = 20.sp),
        )
        Card(
            modifier = Modifier
                .padding(12.dp)
                .weight(0.2f),
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.background,
            elevation = 0.dp,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painter = painterResource(id = if(color == Color.Green){
                        R.drawable.ic_baseline_check_circle_24}
                    else  { R.drawable.ic_baseline_highlight_off_24 }
                    ),
                    contentDescription = "Settings Icon",
                    modifier = Modifier
                        .size(28.dp),
                    tint = color
                )
            }
        }
    }
}


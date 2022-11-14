package com.example.quizapp.presentation.gameScreens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quizapp.R
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.SecondaryGameScreen
import com.example.quizapp.ui.theme.TopBarExpendedHeight
import com.example.quizapp.presentation.QuizViewModel
import com.ramcosta.composedestinations.annotation.Destination


@Composable
@Destination()
fun GameScreen(
    category: String,
    nQuestions: Int,
    difficulty: String,
    viewModel: QuizViewModel = hiltViewModel()
) {
    val state = viewModel.state.value


        if(state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if(state.error != null) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error
            )
        } else {

        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            //           CategoryTopBar(category = "history")
            val category = category
            Text(
                text = category.uppercase(),
                modifier = Modifier.padding(start = 36.dp, top = 20.dp),
                color = SecondaryGameScreen,
                fontSize = 22.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, top = 3.dp), horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Question", modifier = Modifier.padding(top = 5.dp),
                    color = Color.White,
                    fontSize = 40.sp,
                )
                Text(
                    text = "${state.currentQuestionNumber+1}",
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

            QuestionLine(nQuestions, viewModel)
            Text(
                text = state.questions[0].question,
                modifier = Modifier.padding(horizontal = 13.dp),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(45.dp))
            Answers(viewModel)

        }
    }
}

@Composable
fun Answers(viewModel: QuizViewModel) {
    Column(modifier = Modifier.padding(horizontal = 13.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        for (i in viewModel.state.value.shuffledAnswers.indices){
            AnswerOption(viewModel.state.value.shuffledAnswers[i], i, viewModel)
        }
    }
}

@Composable
fun AnswerOption(answer: String, option: Int, viewModel: QuizViewModel) {
    //State Start -> Bol right answer
    //State choose correctly -> Show right answer,
    //State choose wrong -> Show chosen as wrong and show right answer
    val state = viewModel.state.value
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(15.dp), clip = true)
            .background(Color(MaterialTheme.colors.background.value))
            .border(
                BorderStroke(2.dp, color = if (state.answerStatus[option] == "answerCorrect"){
                    Color.Green
                } else if (state.answerStatus[option] == "answerWrong") {
                    Color.Red
                } else {
                    Color(SecondaryGameScreen.value)
                }

                ),
            //    Color(SecondaryGameScreen.value)),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(
                enabled = true,
                onClick = {
                    viewModel.checkAnswer(option)
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .padding(start = 4.dp)
                .weight(1.2f),
            text = answer,

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
                    painter = painterResource(id = if(state.answerStatus[option] == "answerCorrect"){R.drawable.ic_baseline_check_circle_24}
                    else if (state.answerStatus[option] == "answerWrong") { R.drawable.ic_baseline_highlight_off_24 }
                    else{
                        R.drawable.ic_outline_circle_24
                    }

                    ),
                    contentDescription = "Settings Icon",
                    modifier = Modifier
                        .size(28.dp),
                    tint = if (state.answerStatus[option] == "answerCorrect"){
                        Color.Green
                    } else if (state.answerStatus[option] == "answerWrong") {
                        Color.Red
                    } else {
                        SecondaryGameScreen
                    }
                )
            }
        }
    }
}

@Composable
fun QuestionLine(nQuestions: Int, viewModel: QuizViewModel) {

    val questions = viewModel.state.value.questions
    val paddingWidth = 24
//    Spacer(modifier = Modifier.height(5.dp))
    Canvas(modifier = Modifier
        .padding(paddingWidth.dp)
        .background(MaterialTheme.colors.background)
        .fillMaxWidth()
        .height(20.dp)){
        val canvasWidth = size.width
        val canvasHeight = size.height
        val space = 400f/nQuestions
//        val space2 = 60f
        val squareHeight = canvasHeight / 5
        val squareWidth = (((canvasWidth - (nQuestions-1) * space ) / nQuestions))
        for (i in questions.indices){
            drawRect(
                color = if (questions[i].answerStatus == 0){
                    SecondaryGameScreen
                } else if (questions[i].answerStatus == 1){
                    Color.Green
                } else {
                    Color.Red
                },
                topLeft = Offset( (i * space + i * squareWidth) , squareHeight / 2),
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
       //     GameScreen()
        }
    }
}
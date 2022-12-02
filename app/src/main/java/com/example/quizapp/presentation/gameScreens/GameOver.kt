package com.example.quizapp.presentation.gameScreens

import androidx.compose.foundation.*
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
import com.example.quizapp.domain.model.colorMap
import com.example.quizapp.presentation.QuizViewModel
import com.example.quizapp.presentation.destinations.ChooseCategoryScreenDestination
import com.example.quizapp.presentation.destinations.GameScreenDestination
import com.example.quizapp.presentation.destinations.SelectedCategoryScreenDestination
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.SecondaryGameScreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class, ExperimentalFoundationApi::class)
@Composable
fun GameOver(navigator: DestinationsNavigator, viewModel: QuizViewModel, nQuestions: Int

){
    val state = viewModel.state.value
    val listState = rememberLazyListState()
    Column(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxSize()){
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .weight(2f)) {
            Text(
                text = " ${state.nRightAnswers} out of $nQuestions",
                fontSize = 50.sp,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 80.dp),
                color = Color.White
            )
            LazyRow(state = listState,
                flingBehavior = rememberSnapperFlingBehavior(listState),
                content = {
                    items(state.questions.size) {index ->
                        AnswerOverview(question = state.questions[index].question ,
                            myAnswer = state.saveAnswer[index],
                            rightAnswer = state.questions[index].correct_answer,
                            modifier = Modifier.padding(16.dp))
                    }
                })
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 55.dp, vertical = 20.dp),
            Alignment.BottomCenter
        ){
            Button(
                onClick = { navigator.navigate(
                    ChooseCategoryScreenDestination
                ) },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                // .padding(vertical = 10.dp )
                ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray as Color, contentColor = Color.Black
                )
            ) {
                Text("Back to menu", fontSize = 25.sp)
            }
        }
    }
}

@Composable
fun AnswerOverview(
    question: String,
    myAnswer: String,
    rightAnswer: String,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier
        .width(380.dp)
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Text(
            text = question,
            modifier = Modifier.padding(horizontal = 13.dp),
            color = if (myAnswer == rightAnswer)Color.Green else Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Column(modifier = Modifier.padding(horizontal = 13.dp, vertical = 15.dp), verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            if (myAnswer == rightAnswer){
                TextMod(answer = "Your Answer", color = Color.Green)
                AnswerOptionModified(myAnswer, Color.Green)
            }else{
                TextMod(answer = "Your Answer", color = Color.Red)
                AnswerOptionModified(answer = myAnswer, color = Color.Red)
                TextMod(answer = "Right Answer", color = Color.Green)
                AnswerOptionModified(answer = rightAnswer, color = Color.Green)
            }
        }

    }
}

@Composable
fun TextMod(answer:String, color: Color){
    Text(
        text = answer,
        fontSize = 27.sp,
        color = color
    )
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


package com.example.quizapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination()
fun TestScreenApi(
    navigator: DestinationsNavigator,
    viewModel: QuizViewModel = hiltViewModel()
){

    //val questionData = testData.setUpTestData()
    val questionData = viewModel.state.value
    LazyColumn(modifier = Modifier.fillMaxHeight()){
        items(questionData.questions.size){ it ->
            Text(
                text = questionData.questions[it].category,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }

}
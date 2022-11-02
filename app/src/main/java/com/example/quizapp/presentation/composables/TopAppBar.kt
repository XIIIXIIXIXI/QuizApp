package com.example.quizapp.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopAppBar(screenName: String){
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
    ) {
        Box(modifier = Modifier.height(32.dp)){
            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    text = screenName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}

@Composable
@Preview
fun TopAppBarPreview(){
    TopAppBar("History")
}
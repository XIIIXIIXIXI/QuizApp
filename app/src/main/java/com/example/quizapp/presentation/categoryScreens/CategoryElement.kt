package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.Image

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight.Companion.Light

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.*
import java.util.*

@Composable
fun CategoryElement(
    color: Color,
    category: String
) {
    Column(
        modifier = Modifier.padding(17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Card(
                modifier = Modifier
                    .size(100.dp)
                    .border(width = 2.dp, color = color, shape = CircleShape),
                shape = CircleShape,
                backgroundColor = MaterialTheme.colors.background
            ){
                Column( horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = LocalContext.current.resources.getIdentifier(category, "drawable", LocalContext.current.packageName)),
                        contentDescription = "Circle",
                        modifier = Modifier.size(70.dp).padding(top = 20.dp)
                    )
                    Text(
                        text = category.replaceFirstChar { it.uppercase() },
                        fontWeight = Light,
                        fontSize = 10.sp,
                        color = Color.LightGray,
                        //modifier = Modifier.width(100.dp)
                    )
                }
        }


    }

}

@Composable
@Preview
fun CategoryElementPreview(){
    QuizAppTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            CategoryElement(ColorScienceNature, "science")
        }
    }
}
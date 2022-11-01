package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

/*
@Composable
fun CategoryElement() {
    Card(shape = CircleShape, backgroundColor = Color.Green,
        /*modifier = Modifier
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Cyan, shape = CircleShape)*/
    )
    {
        Column(modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.history),
                contentDescription = "Circle",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    //.border(width = 2.dp, color = Color.Cyan, shape = CircleShape),
            )
            Spacer(modifier = Modifier.height(11.dp))
            Text(text = "History", fontSize = 30.sp)
        }


    }
}
*/
@Composable
fun CategoryElement() {
    Column(
        modifier = Modifier.padding(17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .border(width = 2.dp, color = Color.Cyan, shape = CircleShape),
                backgroundColor = Color.Blue,
                shape = CircleShape
            ){
                Column( horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.history),
                        contentDescription = "Circle",
                        modifier = Modifier.size(70.dp)
                    )
                    Text(
                        text = "History",
                        fontWeight = Medium,
                        fontSize = 15.sp,
                        //modifier = Modifier.width(100.dp)
                    )
                }
        }


    }

        }





@Composable
@Preview
fun CategoryElementPreview(){
    CategoryElement()
}
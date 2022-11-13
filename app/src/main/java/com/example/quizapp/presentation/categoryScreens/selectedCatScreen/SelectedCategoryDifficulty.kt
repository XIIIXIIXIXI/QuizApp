package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Shapes

@Composable
fun SelectedCategoryDifficulty(
    modifier: Modifier,
    selectedState: String,
    difficulty:String,
    color: Color,
    onClick: (String) -> Unit = {}
) {

    val iconSize = 35.dp
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedState == difficulty) {
            Text(
                text = "Difficulty",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(iconSize)
            )
        } else {
            Text(
                text = "",
            )
            Spacer(modifier = Modifier.size(iconSize))
        }
/*
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(40.dp)
                    .width(180.dp)
                    .clip(shape = RoundedCornerShape(50.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Green, contentColor = Color.Black
                )
            ) {
                Text(difficulty)
            }

             */
        Button(
            onClick = {onClick(difficulty)},
            shape = Shapes.medium,
            modifier =
            if (difficulty != "All Difficulty") modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = if (difficulty != "Easy")
                    7.dp else 0.dp)
            else modifier
                .fillMaxHeight(),
            elevation = null,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = color, contentColor = Color.Black
            )
        ) {
            Text(difficulty)
        }

    }
}

@Composable
fun DifficultyButton(difficulty:String, modifier: Modifier){

}
@Composable
@Preview
fun SelectedCategoryDifficultyPreview(){
    SelectedCategoryDifficulty(modifier = Modifier, selectedState = "Easy", "easy", color = Color.Yellow)
}
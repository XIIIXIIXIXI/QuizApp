package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.presentation.composables.TopAppBar

@Composable
fun SelectedCategoryScreen(
    modifier: Modifier = Modifier,
    selected: Boolean

){
    val iconSize = 35.dp
   Column(modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       if (selected){
           Text(
               text = "Difficulty",
               color = Color.LightGray
           )
           Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null
               , tint = Color.LightGray, modifier = Modifier.size(iconSize))
       }else{
           Text(
               text = "",
           )
           Spacer(modifier = Modifier.size(iconSize))
       }
       Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .height(40.dp)
            .width(180.dp)
            .clip(shape = RoundedCornerShape(50.dp)),
          colors = ButtonDefaults.buttonColors(
              backgroundColor = Color.Green, contentColor = Color.Black
          )
       ) {
            Text("Easy")
       }

   }
}

@Composable
@Preview
fun TopAppBarPreview(){
    SelectedCategoryScreen(modifier = Modifier, selected = false)
}
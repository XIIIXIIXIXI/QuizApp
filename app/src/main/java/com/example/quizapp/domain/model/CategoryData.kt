package com.example.quizapp.domain.model

import androidx.compose.ui.graphics.Color
import com.example.quizapp.ui.theme.*

data class CategoryData(
    val categories: List<Category>
)

data class Category(
    val name: String,
    val color: Color
)


val categories = CategoryData(

            categories = listOf(
                Category("history", ColorHistory),
                Category("art", ColorArt),
                Category("sports", ColorSports),
                Category("videogames", ColorEntertainmentVideogames),
                Category("science", ColorScienceNature),
                Category("geography", ColorGeography)
            )
        )





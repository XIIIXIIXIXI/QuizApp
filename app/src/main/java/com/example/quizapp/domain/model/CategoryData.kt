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

val categoryMap = mapOf(
    "general knowledge" to 9,
    "books" to 10,
    "film" to 11,
    "music" to 12,
    "musical & theatres" to 13,
    "television" to 14,
    "video games" to 15,
    "board games" to 16,
    "science & nature" to 17,
    "science: computers" to 18,
    "science: mathematics" to 19,
    "mythology" to 20,
    "sports" to 21,
    "geography" to 22,
    "history" to 23,
    "politics" to 24,
    "art" to 25,
    "celebrities" to 26,
    "animals" to 27,
    "vehicles" to 28,
    "comics" to 29,
    "science: gadgets" to 30,
    "anime & manga" to 31,
    "cartton & animations" to 32,
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





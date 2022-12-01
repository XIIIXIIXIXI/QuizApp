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
    "general" to 9,
    "books" to 10,
    "film" to 11,
    "music" to 12,
    "theatre" to 13,
    "television" to 14,
    "videogames" to 15,
    "boardgames" to 16,
    "science" to 17,
    "computers" to 18,
    "math" to 19,
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
    "science_gadgets" to 30,
    "anime_manga" to 31,
    "cartoon_animations" to 32,
    )
val colorMap = mapOf(
    "general" to ColorGeneral,
    "books" to ColorBooks,
    "film" to ColorFilm,
    "music" to ColorMusic,
    "theatre" to ColorTheatre,
    "television" to ColorTelevision,
    "videogames" to ColorVideogames,
    "boardgames" to ColorBoardgames,
    "science" to ColorScience_Nature,
    "computers" to ColorComputers,
    "math" to ColorMath,
    "mythology" to ColorMythologie,
    "sports" to ColorSports,
    "geography" to ColorGeography,
    "history" to ColorHistory,
    "politics" to ColorPolitics,
    "art" to ColorArt,
    "celebrities" to ColorHistory,
    "animals" to ColorAnimals,
    "vehicles" to ColorHistory,
    "comics" to ColorHistory,
    "science_gadgets" to ColorHistory,
    "anime_manga" to ColorHistory,
    "cartoon_animations" to ColorHistory,
)

val categories = CategoryData(

            categories = listOf(
                Category("history", ColorHistory),
                Category("art", ColorArt),
                Category("sports", ColorSports),
                Category("videogames", ColorVideogames),
                Category("science", ColorScience_Nature),
                Category("geography", ColorGeography),
                Category("computers", ColorComputers),
                Category("animals", ColorAnimals),
                Category("books", ColorBooks),
                Category("boardgames", ColorBoardgames),
                Category("math", ColorMath),
                Category("music", ColorMusic),
                Category("theatre", ColorTheatre),
                Category("mythology", ColorMythologie),
                Category("politics", ColorPolitics),
                Category("television", ColorTelevision),
                Category("general", ColorGeneral)
            )
        )





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
val testMap = mapOf(
    "general" to listOf<Int>(300, 118, 123, 59),
    "books" to listOf<Int>(97, 23, 30, 20),
    "film" to listOf<Int>(200, 50, 90, 30),
    "music" to listOf<Int>(300, 90, 50, 50),
    "theatre" to listOf<Int>(25, 7, 8, 6),
    "television" to listOf<Int>(50, 50, 50, 20),
    "videogames" to listOf<Int>(50, 50, 50, 50),
    "boardgames" to listOf<Int>(45, 12, 10, 16),
    "science" to listOf<Int>(50, 44, 50, 40),
    "computers" to listOf<Int>(50, 36, 50, 28),
    "math" to listOf<Int>(40, 7, 14, 9),
    "mythology" to listOf<Int>(45, 10, 18, 7),
    "sports" to listOf<Int>(50, 36, 50, 11),
    "geography" to listOf<Int>(50, 50, 50, 40),
    "history" to listOf<Int>(50, 50, 50, 50),
    "politics" to listOf<Int>(45, 10, 18, 8),
    "art" to listOf<Int>(18, 5, 6, 5),
    "celebrities" to listOf<Int>(30, 6, 20, 4),
    "animals" to listOf<Int>(50, 16, 20, 9),
    "vehicles" to listOf<Int>(50, 12, 20, 10),
    "comics" to listOf<Int>(50, 10, 20, 10),
    "science_gadgets" to listOf<Int>(),
    "anime_manga" to listOf<Int>(),
    "cartoon_animations" to listOf<Int>(),
)
val difficultyToNumber = mapOf(
    "All Difficulty" to 0,
    "Easy" to 1,
    "Medium" to 2,
    "Hard" to 3
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




